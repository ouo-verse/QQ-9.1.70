package com.tencent.aelight.camera.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;
import ps.a;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAEMaterialManager extends QRouteApi {
    String getMaterialZipFolderPath();

    boolean isSpecialTemplate(VideoMaterial videoMaterial);

    String materialListToString(@Nullable ArrayList<a> arrayList);

    ArrayList<a> stringToLastMaterialList(@Nullable String str);
}
