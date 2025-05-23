package com.tencent.aelight.camera.ae.data;

import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEARCakeMaterial extends AEMaterialMetaData {
    public int ID;
    public String lowPackageUrl = "";
    public String lowPackageMd5 = "";
    public String superLowPackageUrl = "";
    public String superLowPackageMd5 = "";
    public String midPackageUrl = "";
    public String midPackageMd5 = "";
    public String highPackageUrl = "";
    public String highPackageMd5 = "";
    public String packageUrl = "";
    public String packageMd5 = "";

    @Override // com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData
    public String toString() {
        return "AEARCakeMaterial{name ='" + this.f69050id + "'id='" + this.f69050id + "', iconurl='" + this.iconurl + "', resurl='" + this.resurl + "'}";
    }
}
