package com.tencent.mobileqq.troop.teamup.publish.part;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper.HWImgCompressHelper;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.PublishMediaEditManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\r\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/publish/part/e;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/PublishMediaEditManager;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/d;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/d;", "K", "()Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/d;", "dataModel", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/HWImgCompressHelper$ImgQuality;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/HWImgCompressHelper$ImgQuality;", "L", "()Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/HWImgCompressHelper$ImgQuality;", "imgQuality", "", "troopUin", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Ljava/lang/String;Lkotlinx/coroutines/CoroutineScope;Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/d;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
final class e extends PublishMediaEditManager {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.d dataModel;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final HWImgCompressHelper.ImgQuality imgQuality;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull String troopUin, @NotNull CoroutineScope scope, @NotNull com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.d dataModel) {
        super(troopUin, scope, 0, 4, null);
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopUin, scope, dataModel);
        } else {
            this.dataModel = dataModel;
            this.imgQuality = HWImgCompressHelper.ImgQuality.STANDARD;
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.PublishMediaEditManager
    @NotNull
    public com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.d K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.dataModel;
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.PublishMediaEditManager
    @NotNull
    public HWImgCompressHelper.ImgQuality L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HWImgCompressHelper.ImgQuality) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.imgQuality;
    }
}
