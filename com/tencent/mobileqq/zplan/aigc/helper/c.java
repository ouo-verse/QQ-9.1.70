package com.tencent.mobileqq.zplan.aigc.helper;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.FileTreeWalk;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.io.FilesKt__FileTreeWalkKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0007\nB\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/helper/c;", "", "", "shaderName", "Lorg/json/JSONObject;", "extras", "", "a", "gltfPath", "Lcom/tencent/mobileqq/zplan/aigc/helper/c$b;", "b", "Ljava/lang/String;", "TAG", "c", "bodyV3ShaderName", "d", "bodyShaderNamePrefix", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f330295a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String TAG = "AvatarUGCMaterialHelper";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final String bodyV3ShaderName = "M_CustomBody_V3";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final String bodyShaderNamePrefix = "M_CustomBody_";

    c() {
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x006d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean a(String shaderName, JSONObject extras) {
        boolean contains$default;
        boolean z16;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        JSONObject optJSONObject5;
        try {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) shaderName, (CharSequence) bodyShaderNamePrefix, false, 2, (Object) null);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (contains$default) {
            return false;
        }
        JSONObject optJSONObject6 = extras.optJSONObject(com.tencent.luggage.wxa.c8.c.f123378k);
        if ((optJSONObject6 == null || (optJSONObject5 = optJSONObject6.optJSONObject("parameters")) == null || !optJSONObject5.has("BaseColor")) ? false : true) {
            JSONObject optJSONObject7 = extras.optJSONObject(com.tencent.luggage.wxa.c8.c.f123378k);
            if ((optJSONObject7 == null || (optJSONObject3 = optJSONObject7.optJSONObject("parameters")) == null || (optJSONObject4 = optJSONObject3.optJSONObject("BaseColor")) == null || !optJSONObject4.has("texture")) ? false : true) {
                JSONObject optJSONObject8 = extras.optJSONObject(com.tencent.luggage.wxa.c8.c.f123378k);
                if (optJSONObject8 != null && (optJSONObject = optJSONObject8.optJSONObject("parameters")) != null && (optJSONObject2 = optJSONObject.optJSONObject("BaseColor")) != null) {
                    if (optJSONObject2.has("colorspace")) {
                        z16 = true;
                        if (!z16) {
                            return true;
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
        }
        return false;
    }

    public final UGCMaterialInfo b(String gltfPath) {
        String readText;
        boolean contains$default;
        String str;
        FileTreeWalk walk$default;
        int i3;
        String substringBeforeLast$default;
        String gltfPath2 = gltfPath;
        String str2 = "extras";
        Intrinsics.checkNotNullParameter(gltfPath2, "gltfPath");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            readText = FilesKt__FileReadWriteKt.readText(new File(gltfPath2), Charsets.UTF_8);
            JSONArray jSONArray = new JSONObject(readText).getJSONArray("materials");
            int length = jSONArray.length();
            int i16 = 0;
            while (i16 < length) {
                String matName = jSONArray.getJSONObject(i16).getString("name");
                JSONObject jSONObject = jSONArray.getJSONObject(i16).getJSONObject(str2);
                String matSlotName = jSONObject.getString("materialSlotName");
                String shaderName = jSONObject.getJSONObject(com.tencent.luggage.wxa.c8.c.f123378k).getJSONObject("source").getString("buffer");
                String str3 = TAG;
                StringBuilder sb5 = new StringBuilder();
                JSONArray jSONArray2 = jSONArray;
                sb5.append("ugc material info. material name: ");
                sb5.append(matName);
                sb5.append(", matSlotName: ");
                sb5.append(matSlotName);
                sb5.append(", shaderName: ");
                sb5.append(shaderName);
                QLog.i(str3, 1, sb5.toString());
                Intrinsics.checkNotNullExpressionValue(shaderName, "shaderName");
                int i17 = length;
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) shaderName, (CharSequence) bodyV3ShaderName, false, 2, (Object) null);
                if (contains$default) {
                    arrayList2.add(Integer.valueOf(i16));
                } else {
                    Intrinsics.checkNotNullExpressionValue(jSONObject, str2);
                    if (a(shaderName, jSONObject)) {
                        String baseColorName = jSONObject.getJSONObject(com.tencent.luggage.wxa.c8.c.f123378k).getJSONObject("parameters").getJSONObject("BaseColor").getString("texture");
                        File parentFile = new File(gltfPath2).getParentFile();
                        Intrinsics.checkNotNullExpressionValue(parentFile, "File(gltfPath).parentFile");
                        str = str2;
                        walk$default = FilesKt__FileTreeWalkKt.walk$default(parentFile, null, 1, null);
                        Iterator<File> it = walk$default.iterator();
                        String str4 = "";
                        while (it.hasNext()) {
                            File next = it.next();
                            String name = next.getName();
                            Intrinsics.checkNotNullExpressionValue(name, "file.name");
                            Iterator<File> it5 = it;
                            substringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(name, ".", (String) null, 2, (Object) null);
                            if (Intrinsics.areEqual(substringBeforeLast$default, baseColorName)) {
                                String absolutePath = next.getAbsolutePath();
                                Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                                str4 = absolutePath;
                            }
                            it = it5;
                        }
                        boolean areEqual = Intrinsics.areEqual(jSONObject.getJSONObject(com.tencent.luggage.wxa.c8.c.f123378k).getJSONObject("parameters").getJSONObject("BaseColor").getString("colorspace"), "srgb");
                        Intrinsics.checkNotNullExpressionValue(matSlotName, "matSlotName");
                        Intrinsics.checkNotNullExpressionValue(matName, "matName");
                        Intrinsics.checkNotNullExpressionValue(baseColorName, "baseColorName");
                        i3 = i16;
                        arrayList.add(new UGCMaterial("_1_texture", matSlotName, matName, i16, baseColorName, str4, areEqual));
                        i16 = i3 + 1;
                        gltfPath2 = gltfPath;
                        jSONArray = jSONArray2;
                        length = i17;
                        str2 = str;
                    }
                }
                str = str2;
                i3 = i16;
                i16 = i3 + 1;
                gltfPath2 = gltfPath;
                jSONArray = jSONArray2;
                length = i17;
                str2 = str;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return new UGCMaterialInfo(arrayList, arrayList2);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0014\u001a\u0004\b\u0011\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u001d\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/helper/c$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "textureName", "b", "d", "matSlotName", "c", "getMatName", "matName", "I", "()I", "matSlotId", "baseColorName", "f", "baseColorFileAbsolutePath", "g", "Z", "()Z", "isSRGB", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Z)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.aigc.helper.c$a, reason: from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class UGCMaterial {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String textureName;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final String matSlotName;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final String matName;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int matSlotId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final String baseColorName;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final String baseColorFileAbsolutePath;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSRGB;

        public UGCMaterial(String textureName, String matSlotName, String matName, int i3, String baseColorName, String baseColorFileAbsolutePath, boolean z16) {
            Intrinsics.checkNotNullParameter(textureName, "textureName");
            Intrinsics.checkNotNullParameter(matSlotName, "matSlotName");
            Intrinsics.checkNotNullParameter(matName, "matName");
            Intrinsics.checkNotNullParameter(baseColorName, "baseColorName");
            Intrinsics.checkNotNullParameter(baseColorFileAbsolutePath, "baseColorFileAbsolutePath");
            this.textureName = textureName;
            this.matSlotName = matSlotName;
            this.matName = matName;
            this.matSlotId = i3;
            this.baseColorName = baseColorName;
            this.baseColorFileAbsolutePath = baseColorFileAbsolutePath;
            this.isSRGB = z16;
        }

        /* renamed from: a, reason: from getter */
        public final String getBaseColorFileAbsolutePath() {
            return this.baseColorFileAbsolutePath;
        }

        /* renamed from: b, reason: from getter */
        public final String getBaseColorName() {
            return this.baseColorName;
        }

        /* renamed from: c, reason: from getter */
        public final int getMatSlotId() {
            return this.matSlotId;
        }

        /* renamed from: d, reason: from getter */
        public final String getMatSlotName() {
            return this.matSlotName;
        }

        /* renamed from: e, reason: from getter */
        public final String getTextureName() {
            return this.textureName;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getIsSRGB() {
            return this.isSRGB;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((((((((this.textureName.hashCode() * 31) + this.matSlotName.hashCode()) * 31) + this.matName.hashCode()) * 31) + this.matSlotId) * 31) + this.baseColorName.hashCode()) * 31) + this.baseColorFileAbsolutePath.hashCode()) * 31;
            boolean z16 = this.isSRGB;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        public String toString() {
            return "UGCMaterial(textureName=" + this.textureName + ", matSlotName=" + this.matSlotName + ", matName=" + this.matName + ", matSlotId=" + this.matSlotId + ", baseColorName=" + this.baseColorName + ", baseColorFileAbsolutePath=" + this.baseColorFileAbsolutePath + ", isSRGB=" + this.isSRGB + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UGCMaterial)) {
                return false;
            }
            UGCMaterial uGCMaterial = (UGCMaterial) other;
            return Intrinsics.areEqual(this.textureName, uGCMaterial.textureName) && Intrinsics.areEqual(this.matSlotName, uGCMaterial.matSlotName) && Intrinsics.areEqual(this.matName, uGCMaterial.matName) && this.matSlotId == uGCMaterial.matSlotId && Intrinsics.areEqual(this.baseColorName, uGCMaterial.baseColorName) && Intrinsics.areEqual(this.baseColorFileAbsolutePath, uGCMaterial.baseColorFileAbsolutePath) && this.isSRGB == uGCMaterial.isSRGB;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\t\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u000b\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/helper/c$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/mobileqq/zplan/aigc/helper/c$a;", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "ugcMaterials", "hideMaterialSlotIds", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.aigc.helper.c$b, reason: from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class UGCMaterialInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final List<UGCMaterial> ugcMaterials;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final List<Integer> hideMaterialSlotIds;

        public UGCMaterialInfo(List<UGCMaterial> ugcMaterials, List<Integer> hideMaterialSlotIds) {
            Intrinsics.checkNotNullParameter(ugcMaterials, "ugcMaterials");
            Intrinsics.checkNotNullParameter(hideMaterialSlotIds, "hideMaterialSlotIds");
            this.ugcMaterials = ugcMaterials;
            this.hideMaterialSlotIds = hideMaterialSlotIds;
        }

        public final List<Integer> a() {
            return this.hideMaterialSlotIds;
        }

        public final List<UGCMaterial> b() {
            return this.ugcMaterials;
        }

        public int hashCode() {
            return (this.ugcMaterials.hashCode() * 31) + this.hideMaterialSlotIds.hashCode();
        }

        public String toString() {
            return "UGCMaterialInfo(ugcMaterials=" + this.ugcMaterials + ", hideMaterialSlotIds=" + this.hideMaterialSlotIds + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UGCMaterialInfo)) {
                return false;
            }
            UGCMaterialInfo uGCMaterialInfo = (UGCMaterialInfo) other;
            return Intrinsics.areEqual(this.ugcMaterials, uGCMaterialInfo.ugcMaterials) && Intrinsics.areEqual(this.hideMaterialSlotIds, uGCMaterialInfo.hideMaterialSlotIds);
        }
    }
}
