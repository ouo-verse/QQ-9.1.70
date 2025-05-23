package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupSchoolNoticeDetailRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolNoticeContent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/c;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/HWDetailMediaDataModel;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupSchoolNoticeDetailRsp;", "detail", "Lkotlin/Function0;", "", "callback", "v", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "troopUin", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c extends HWDetailMediaDataModel<GetGroupSchoolNoticeDetailRsp> {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull CoroutineScope scope, @NotNull String troopUin) {
        super(scope, troopUin);
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) scope, (Object) troopUin);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.HWDetailMediaDataModel
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void t(@NotNull GetGroupSchoolNoticeDetailRsp detail, @Nullable Function0<Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) detail, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(detail, "detail");
        TitleItem p16 = p();
        String str = detail.content.title;
        Intrinsics.checkNotNullExpressionValue(str, "detail.content.title");
        p16.setTitle(str);
        u(detail.authorUin, detail.publishTime, callback);
        GroupSchoolNoticeContent groupSchoolNoticeContent = detail.content;
        Intrinsics.checkNotNullExpressionValue(groupSchoolNoticeContent, "detail.content");
        s(groupSchoolNoticeContent);
    }
}
