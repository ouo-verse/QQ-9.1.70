package com.tencent.av.opengl.effects;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.light.avatar.AvatarAIInfo;
import trpc.qq_av.avatar2d_aidata.SuperAvatarAIData$AvatarAIEvent;
import trpc.qq_av.avatar2d_aidata.SuperAvatarAIData$AvatarAIInfo;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    public static AvatarAIInfo a(byte[] bArr) {
        SuperAvatarAIData$AvatarAIInfo superAvatarAIData$AvatarAIInfo = new SuperAvatarAIData$AvatarAIInfo();
        try {
            superAvatarAIData$AvatarAIInfo.mergeFrom(bArr);
            int i3 = superAvatarAIData$AvatarAIInfo.version.get();
            int i16 = superAvatarAIData$AvatarAIInfo.frame_id.get();
            float[] fArr = new float[superAvatarAIData$AvatarAIInfo.sky_box_transform.size()];
            for (int i17 = 0; i17 < superAvatarAIData$AvatarAIInfo.sky_box_transform.size(); i17++) {
                fArr[i17] = superAvatarAIData$AvatarAIInfo.sky_box_transform.get(i17).floatValue();
            }
            byte[] byteArray = superAvatarAIData$AvatarAIInfo.f437235face.get().toByteArray();
            byte[] byteArray2 = superAvatarAIData$AvatarAIInfo.body.get().toByteArray();
            HashMap hashMap = new HashMap();
            for (int i18 = 0; i18 < superAvatarAIData$AvatarAIInfo.events.size(); i18++) {
                hashMap.put(superAvatarAIData$AvatarAIInfo.events.get(i18).key.get(), superAvatarAIData$AvatarAIInfo.events.get(i18).value.get());
            }
            return new AvatarAIInfo(true, i3, i16, fArr, byteArray, byteArray2, hashMap);
        } catch (InvalidProtocolBufferMicroException unused) {
            QLog.e("generateAvatarAIInfoFromPB", 1, "parse avatarAIInfoBuffer failed");
            return null;
        }
    }

    public static byte[] b(AvatarAIInfo avatarAIInfo) {
        SuperAvatarAIData$AvatarAIInfo superAvatarAIData$AvatarAIInfo = new SuperAvatarAIData$AvatarAIInfo();
        superAvatarAIData$AvatarAIInfo.version.set(avatarAIInfo.version);
        superAvatarAIData$AvatarAIInfo.frame_id.set(avatarAIInfo.frameID);
        if (avatarAIInfo.skyBoxTransform != null) {
            ArrayList arrayList = new ArrayList();
            for (float f16 : avatarAIInfo.skyBoxTransform) {
                arrayList.add(Float.valueOf(f16));
            }
            superAvatarAIData$AvatarAIInfo.sky_box_transform.set(arrayList);
        }
        byte[] bArr = avatarAIInfo.f423803face;
        if (bArr != null) {
            superAvatarAIData$AvatarAIInfo.f437235face.set(ByteStringMicro.copyFrom(bArr));
        }
        byte[] bArr2 = avatarAIInfo.body;
        if (bArr2 != null) {
            superAvatarAIData$AvatarAIInfo.body.set(ByteStringMicro.copyFrom(bArr2));
        }
        if (avatarAIInfo.events != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry<String, String> entry : avatarAIInfo.events.entrySet()) {
                SuperAvatarAIData$AvatarAIEvent superAvatarAIData$AvatarAIEvent = new SuperAvatarAIData$AvatarAIEvent();
                superAvatarAIData$AvatarAIEvent.key.set(entry.getKey());
                superAvatarAIData$AvatarAIEvent.value.set(entry.getValue());
                arrayList2.add(superAvatarAIData$AvatarAIEvent);
            }
            superAvatarAIData$AvatarAIInfo.events.set(arrayList2);
        }
        return superAvatarAIData$AvatarAIInfo.toByteArray();
    }
}
