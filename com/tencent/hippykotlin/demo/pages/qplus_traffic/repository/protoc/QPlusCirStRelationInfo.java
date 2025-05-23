package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public final class QPlusCirStRelationInfo implements ISSOReqModel, ISSORspModel<QPlusCirStRelationInfo> {
    public final boolean isBlock;
    public final boolean isBlocked;
    public final boolean isFriend;
    public final boolean isUncare;
    public final int relation;
    public final int relationState;
    public final int score;
    public final String uin;

    public QPlusCirStRelationInfo() {
        this(null, 0, 0, 0, false, false, false, false, 255, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("uin", this.uin);
        eVar.t("relation", this.relation);
        eVar.t("relationState", this.relationState);
        eVar.t(LocalPhotoFaceInfo.SCORE, this.score);
        eVar.w("isBlock", this.isBlock);
        eVar.w("isBlocked", this.isBlocked);
        eVar.w(IProfileProtocolConst.PARAM_IS_FRIEND, this.isFriend);
        eVar.w("isUncare", this.isUncare);
        return eVar;
    }

    public QPlusCirStRelationInfo(String str, int i3, int i16, int i17, boolean z16, boolean z17, boolean z18, boolean z19) {
        this.uin = str;
        this.relation = i3;
        this.relationState = i16;
        this.score = i17;
        this.isBlock = z16;
        this.isBlocked = z17;
        this.isFriend = z18;
        this.isUncare = z19;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusCirStRelationInfo decode(e eVar) {
        return new QPlusCirStRelationInfo(eVar.q("uin", ""), eVar.k("relation", 0), eVar.k("relationState", 0), eVar.k(LocalPhotoFaceInfo.SCORE, 0), eVar.g("isBlock", false), eVar.g("isBlocked", false), eVar.g(IProfileProtocolConst.PARAM_IS_FRIEND, false), eVar.g("isUncare", false));
    }

    public /* synthetic */ QPlusCirStRelationInfo(String str, int i3, int i16, int i17, boolean z16, boolean z17, boolean z18, boolean z19, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0, 0, 0, false, false, false, false);
    }
}
