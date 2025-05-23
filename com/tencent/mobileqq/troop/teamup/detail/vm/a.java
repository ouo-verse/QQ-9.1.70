package com.tencent.mobileqq.troop.teamup.detail.vm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.ContentItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.HWDetailMediaDataModel;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.ImageItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpImage;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTeamDetail;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/detail/vm/a;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/HWDetailMediaDataModel;", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;", "detail", "Lkotlin/Function0;", "", "callback", "w", "", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/ImageItem;", "v", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", "o", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "troopUin", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a extends HWDetailMediaDataModel<TeamUpTeamDetail> {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull CoroutineScope scope, @NotNull String troopUin) {
        super(scope, troopUin);
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) scope, (Object) troopUin);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.HWDetailMediaDataModel
    @NotNull
    public List<BaseItem> o() {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(k());
            arrayListOf.addAll(n());
            arrayListOf.addAll(r());
            arrayListOf.addAll(j());
            arrayListOf.addAll(l());
            return arrayListOf;
        }
        return (List) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    @NotNull
    public final List<ImageItem> v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return n();
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.HWDetailMediaDataModel
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void t(@NotNull TeamUpTeamDetail detail, @Nullable Function0<Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) detail, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(detail, "detail");
        ContentItem k3 = k();
        String str = detail.content;
        Intrinsics.checkNotNullExpressionValue(str, "detail.content");
        k3.setContent(str);
        k().setMarginBottomPx(ViewUtils.dpToPx(6.0f));
        n().clear();
        ArrayList<TeamUpImage> arrayList = detail.images;
        Intrinsics.checkNotNullExpressionValue(arrayList, "detail.images");
        for (TeamUpImage teamUpImage : arrayList) {
            ArrayList<ImageItem> n3 = n();
            ImageItem imageItem = new ImageItem();
            imageItem.setWidth(teamUpImage.width);
            imageItem.setHeight(teamUpImage.height);
            imageItem.setHttpUrl(teamUpImage.picUrl);
            n3.add(imageItem);
        }
        if (callback != null) {
            callback.invoke();
        }
    }
}
