package com.tencent.biz.qqcircle.manager.diffres.beans;

import com.tencent.biz.qqcircle.manager.diffres.QCircleActionType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/biz/qqcircle/manager/diffres/beans/QFSCommentFeedbackResPackage;", "Lcom/tencent/biz/qqcircle/manager/diffres/beans/QCircleBaseResPackage;", "()V", "getPreloadZipList", "", "", "getResRefreshActionTypeList", "Lcom/tencent/biz/qqcircle/manager/diffres/QCircleActionType;", "Companion", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class QFSCommentFeedbackResPackage extends QCircleBaseResPackage {

    @NotNull
    public static final String DOWNLOAD_PACKAGE = "animation";

    @NotNull
    public static final String DOWNLOAD_ZIP_URL = "https://downv6.qq.com/video_story/qcircle/zip/defaultmode/915/animation.zip";

    @NotNull
    public static final String GENERAL_ANIM_LO = "qvideo_skin_comment_general_lo.json";

    @NotNull
    public static final String GENERAL_STATIC_PNG = "qvideo_skin_icon_general_comment.png";

    @NotNull
    public static final String SATISFIED_ANIM_LO = "qvideo_skin_comment_satisfied_lo.json";

    @NotNull
    public static final String SATISFIED_STATIC_PNG = "qvideo_skin_icon_satisfied_comment.png";

    @NotNull
    public static final String UNSATISFIED_ANIM_LO = "qvideo_skin_comment_unsatisfactory_lo.json";

    @NotNull
    public static final String UNSATISFIED_STATIC_PNG = "qvideo_skin_icon_unsatisfactory_comment.png";

    @NotNull
    public static final String VERY_SATISFIED_ANIM_LO = "qvideo_skin_comment_very_satisfied_lo.json";

    @NotNull
    public static final String VERY_SATISFIED_STATIC_PNG = "qvideo_skin_icon_very_satisfied_comment.png";

    @NotNull
    public static final String VERY_UNSATISFIED_ANIM_LO = "qvideo_skin_comment_very_dissatisfied_lo.json";

    @NotNull
    public static final String VERY_UNSATISFIED_STATIC_PNG = "qvideo_skin_icon_very_dissatisfied_comment.png";

    @Override // com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseResPackage
    @NotNull
    public List<String> getPreloadZipList() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(DOWNLOAD_ZIP_URL);
        return arrayListOf;
    }

    @Override // com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseResPackage
    @NotNull
    public List<QCircleActionType> getResRefreshActionTypeList() {
        return new ArrayList();
    }
}
