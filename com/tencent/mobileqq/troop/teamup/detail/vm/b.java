package com.tencent.mobileqq.troop.teamup.detail.vm;

import android.app.Activity;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopPreviewMediaApi;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.DetailMediaEditManager;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.HWDetailMediaDataModel;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.ImageItem;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTeamDetail;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B:\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00070\u0013\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/detail/vm/b;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/DetailMediaEditManager;", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/HWDetailMediaDataModel;", "K", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/HWDetailMediaDataModel;", "k", "()Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/HWDetailMediaDataModel;", "dataModel", "", "troopUin", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "height", "notifyRecyclerViewHeight", "<init>", "(Ljava/lang/String;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b extends DetailMediaEditManager<TeamUpTeamDetail> {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final HWDetailMediaDataModel<TeamUpTeamDetail> dataModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull String troopUin, @NotNull CoroutineScope scope, @NotNull Function1<? super Integer, Unit> notifyRecyclerViewHeight) {
        super(troopUin, scope, notifyRecyclerViewHeight);
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(notifyRecyclerViewHeight, "notifyRecyclerViewHeight");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopUin, scope, notifyRecyclerViewHeight);
        } else {
            this.dataModel = new a(scope, troopUin);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.DetailMediaEditManager
    @NotNull
    public HWDetailMediaDataModel<TeamUpTeamDetail> k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HWDetailMediaDataModel) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.dataModel;
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.DetailMediaEditManager, qs2.a
    public void m(@NotNull BaseItem item, @Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if ((item instanceof ImageItem) && (k() instanceof a)) {
            List<ImageItem> v3 = ((a) k()).v();
            int max = Math.max(v3.indexOf(item), 0);
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<T> it = v3.iterator();
            while (it.hasNext()) {
                String httpUrl = ((ImageItem) it.next()).getHttpUrl();
                if (httpUrl != null) {
                    arrayList.add(httpUrl);
                }
            }
            if (activity != null) {
                ((ITroopPreviewMediaApi) QRoute.api(ITroopPreviewMediaApi.class)).showPicture(activity, max, arrayList);
                return;
            }
            return;
        }
        super.m(item, activity);
    }
}
