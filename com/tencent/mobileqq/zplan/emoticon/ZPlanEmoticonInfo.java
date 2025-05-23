package com.tencent.mobileqq.zplan.emoticon;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.data.ZPlanPicExtraData;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B{\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\t\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\t\u0012\b\b\u0002\u0010#\u001a\u00020\t\u0012\b\b\u0002\u0010&\u001a\u00020\t\u0012\b\b\u0002\u0010)\u001a\u00020\t\u0012\b\u0010/\u001a\u0004\u0018\u00010*\u00a2\u0006\u0004\b0\u00101R\u0017\u0010\b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007R\u0017\u0010\u001a\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\rR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007R\u0017\u0010 \u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001f\u0010\rR\u0017\u0010#\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u000b\u001a\u0004\b\"\u0010\rR\u0017\u0010&\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b%\u0010\rR\u0017\u0010)\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b'\u0010\u000b\u001a\u0004\b(\u0010\rR\u0019\u0010/\u001a\u0004\u0018\u00010*8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/ZPlanEmoticonInfo;", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "Landroid/os/Parcelable;", "", "d", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "path", "", "e", "I", "getSessionType", "()I", ShortVideoConstants.PARAM_KEY_SESSION_TYPE, "f", "getSelfUin", "selfUin", h.F, "getFriendUin", "friendUin", "i", "getTroopUin", "troopUin", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getId", "id", BdhLogUtil.LogTag.Tag_Conn, "a", "emoticonOrActionName", "D", "getOriginType", "originType", "E", "getPlayerNumber", "playerNumber", UserInfo.SEX_FEMALE, "getWidth", "width", "G", "getHeight", "height", "Lcom/tencent/mobileqq/data/ZPlanPicExtraData;", "H", "Lcom/tencent/mobileqq/data/ZPlanPicExtraData;", "b", "()Lcom/tencent/mobileqq/data/ZPlanPicExtraData;", "zPlanPicExtraData", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IIIILcom/tencent/mobileqq/data/ZPlanPicExtraData;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonInfo extends EmoticonInfo {

    /* renamed from: C, reason: from kotlin metadata */
    private final String emoticonOrActionName;

    /* renamed from: D, reason: from kotlin metadata */
    private final int originType;

    /* renamed from: E, reason: from kotlin metadata */
    private final int playerNumber;

    /* renamed from: F, reason: from kotlin metadata */
    private final int width;

    /* renamed from: G, reason: from kotlin metadata */
    private final int height;

    /* renamed from: H, reason: from kotlin metadata */
    private final ZPlanPicExtraData zPlanPicExtraData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String path;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int sessionType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String selfUin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final String friendUin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final String troopUin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int id;

    public ZPlanEmoticonInfo(String path, int i3, String selfUin, String str, String str2, int i16, String str3, int i17, int i18, int i19, int i26, ZPlanPicExtraData zPlanPicExtraData) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        this.path = path;
        this.sessionType = i3;
        this.selfUin = selfUin;
        this.friendUin = str;
        this.troopUin = str2;
        this.id = i16;
        this.emoticonOrActionName = str3;
        this.originType = i17;
        this.playerNumber = i18;
        this.width = i19;
        this.height = i26;
        this.zPlanPicExtraData = zPlanPicExtraData;
    }

    /* renamed from: a, reason: from getter */
    public final String getEmoticonOrActionName() {
        return this.emoticonOrActionName;
    }

    /* renamed from: b, reason: from getter */
    public final ZPlanPicExtraData getZPlanPicExtraData() {
        return this.zPlanPicExtraData;
    }

    public final String getPath() {
        return this.path;
    }
}
