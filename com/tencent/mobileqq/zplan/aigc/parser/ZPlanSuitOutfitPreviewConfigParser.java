package com.tencent.mobileqq.zplan.aigc.parser;

import com.google.gson.JsonSyntaxException;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.zootopia.utils.DataConvertUtil;
import com.tencent.mobileqq.zplan.aigc.data.ZplanSuitOutfitPreviewConfig;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u0006B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/parser/ZPlanSuitOutfitPreviewConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/zplan/aigc/parser/ZPlanSuitOutfitPreviewConfigParser$b;", "", "content", "c", "b", "", "success", "", "onCdnDownload", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanSuitOutfitPreviewConfigParser extends BaseConfigParser<b> {

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u00102\u00020\u0001:\u0001\nB\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002R\u0017\u0010\f\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/parser/ZPlanSuitOutfitPreviewConfigParser$b;", "Lcom/tencent/freesia/IConfigData;", "", "Lcom/tencent/mobileqq/zplan/aigc/data/ZplanSuitOutfitPreviewConfig;", "c", "", "jsonStr", "b", "d", "Lcom/tencent/mobileqq/zplan/aigc/data/ZplanSuitOutfitPreviewConfig;", "a", "()Lcom/tencent/mobileqq/zplan/aigc/data/ZplanSuitOutfitPreviewConfig;", "outfitConfig", "content", "<init>", "([B)V", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements IConfigData {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final ZplanSuitOutfitPreviewConfig outfitConfig;

        public b(byte[] bArr) {
            ZplanSuitOutfitPreviewConfig c16;
            this.outfitConfig = (bArr == null || (c16 = c(bArr)) == null) ? b("{\n  \"male\": [\n    {\n      \"headAction\": \"CMShow/Assets/Animation/Character/Player/Animation/AnimSequence/A_Male/StandingSideways/HeadAnimation/A_CH_M_Idle_Emote_Anim\",\n      \"bodyAction\": \"CMShow/Assets/Animation/Character/Player/Animation/AnimSequence/A_Male/StandingSideways/BodyAnimation/A_CH_M_Idle\",\n      \"beginTime\": 3.629,\n      \"endTime\": 3.629,\n      \"frameInterval\": 0.33\n    },\n    {\n      \"headAction\": \"CMShow/Assets/AnimationUnpak/Character/Player/Montage/A_Male/HeadAnimation/A_CH_M_H_CasualWear_01_Emote_Anim_Montage\",\n      \"bodyAction\": \"CMShow/Assets/AnimationUnpak/Character/Player/Montage/A_Male/BodyAnimation/A_CH_M_H_CasualWear_01_Montage\",\n      \"beginTime\": 3.948,\n      \"endTime\": 3.948,\n      \"frameInterval\": 0.33\n    },\n    {\n      \"headAction\": \"CMShow/Assets/AnimationUnpak/Character/Player/Montage/A_Male/HeadAnimation/A_CH_M_H_BaseHair_Emote_Anim_Montage\",\n      \"bodyAction\": \"CMShow/Assets/AnimationUnpak/Character/Player/Montage/A_Male/BodyAnimation/A_CH_M_H_BaseHair_Montage\",\n      \"beginTime\": 3.084,\n      \"endTime\": 3.084,\n      \"frameInterval\": 0.33\n    },\n    {\n      \"headAction\": \"CMShow/Assets/AnimationUnpak/Character/Player/Montage/A_Male/HeadAnimation/A_CH_M_G_SayHello_Emote_Anim_Montage\",\n      \"bodyAction\": \"CMShow/Assets/AnimationUnpak/Character/Player/Montage/A_Male/BodyAnimation/A_CH_M_G_SayHello_Montage\",\n      \"beginTime\": 4.524,\n      \"endTime\": 4.524,\n      \"frameInterval\": 0.33\n    }\n  ],\n  \"female\": [\n    {\n      \"headAction\": \"CMShow/Assets/Animation/Character/Player/Animation/AnimSequence/A_Female/StandingSideways/HeadAnimation/A_CH_F_Idle_Emote_Anim\",\n      \"bodyAction\": \"CMShow/Assets/Animation/Character/Player/Animation/AnimSequence/A_Female/StandingSideways/BodyAnimation/A_CH_F_Idle\",\n      \"beginTime\": 3.128,\n      \"endTime\": 3.128,\n      \"frameInterval\": 0.33\n    },\n    {\n      \"headAction\": \"CMShow/Assets/AnimationUnpak/Character/Player/Montage/A_Female/HeadAnimation/A_CH_F_G_Charming_01_Emote_Anim_Montage\",\n      \"bodyAction\": \"CMShow/Assets/AnimationUnpak/Character/Player/Montage/A_Female/BodyAnimation/A_CH_F_G_Charming_01_Montage\",\n      \"beginTime\": 0.842,\n      \"endTime\": 0.842,\n      \"frameInterval\": 0.33\n    },\n    {\n      \"headAction\": \"CMShow/Assets/AnimationUnpak/Character/Player/Montage/A_Female/HeadAnimation/A_CH_F_G_ShowWear_02_Emote_BS_Montage\",\n      \"bodyAction\": \"CMShow/Assets/AnimationUnpak/Character/Player/Montage/A_Female/BodyAnimation/A_CH_F_G_ShowWear_02_Montage\",\n      \"beginTime\": 5.309,\n      \"endTime\": 5.309,\n      \"frameInterval\": 0.33\n    },\n    {\n      \"headAction\": \"CMShow/Assets/AnimationUnpak/Character/Player/Montage/A_Female/HeadAnimation/A_CH_F_H_HighHeel_01_Emote_Montage\",\n      \"bodyAction\": \"CMShow/Assets/AnimationUnpak/Character/Player/Montage/A_Female/BodyAnimation/A_CH_F_H_HighHeel_01_Montage\",\n      \"beginTime\": 3.564,\n      \"endTime\": 3.564,\n      \"frameInterval\": 0.33\n    },\n    {\n      \"headAction\": \"CMShow/Assets/AnimationUnpak/Character/Player/Montage/A_Female/HeadAnimation/A_CH_F_HandBag01_ToBag_Emote_Montage\",\n      \"bodyAction\": \"CMShow/Assets/AnimationUnpak/Character/Player/Montage/A_Female/BodyAnimation/A_CH_F_HandBag01_ToBag_Montage\",\n      \"beginTime\": 0.775,\n      \"endTime\": 0.775,\n      \"frameInterval\": 0.33\n    }\n  ]\n}\n") : c16;
        }

        private final ZplanSuitOutfitPreviewConfig b(String jsonStr) {
            try {
                Object fromJson = DataConvertUtil.f329546a.a().fromJson(jsonStr, (Class<Object>) ZplanSuitOutfitPreviewConfig.class);
                Intrinsics.checkNotNullExpressionValue(fromJson, "{\n                DataCo\u2026class.java)\n            }");
                return (ZplanSuitOutfitPreviewConfig) fromJson;
            } catch (JsonSyntaxException e16) {
                QLog.e("ZPlanSuitOutfitPreviewConfigParser_Config", 1, "parse fail. ", e16);
                return new ZplanSuitOutfitPreviewConfig();
            }
        }

        private final ZplanSuitOutfitPreviewConfig c(byte[] bArr) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            return b(new String(bArr, UTF_8));
        }

        /* renamed from: a, reason: from getter */
        public final ZplanSuitOutfitPreviewConfig getOutfitConfig() {
            return this.outfitConfig;
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        return new b(null);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b parse(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return new b(content);
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onCdnDownload(boolean success) {
        QLog.i("ZPlanSuitOutfitPreviewConfigParser", 1, "onCdnDownload success:" + success);
    }
}
