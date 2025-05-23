package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model;

import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolNoticeContent;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskCheckInInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J \u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/a;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/HWDetailMediaDataModel;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/a;", "data", "Lkotlin/Function0;", "", "callback", "v", "", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", "o", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/UserInfoTitleItem;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/UserInfoTitleItem;", "userInfoTitleItem", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/MediaListItem;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/MediaListItem;", "mediaListItem", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "troopUin", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a extends HWDetailMediaDataModel<com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final UserInfoTitleItem userInfoTitleItem;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MediaListItem mediaListItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull CoroutineScope scope, @NotNull String troopUin) {
        super(scope, troopUin);
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) scope, (Object) troopUin);
        } else {
            this.userInfoTitleItem = new UserInfoTitleItem(null, null, null, false, false, 31, null);
            this.mediaListItem = new MediaListItem(3, ViewUtils.dip2px(3.5f));
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.HWDetailMediaDataModel
    @NotNull
    public List<BaseItem> o() {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList<BaseMediaItem> arrayList = new ArrayList<>();
        arrayList.addAll(n());
        arrayList.addAll(r());
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this.userInfoTitleItem, k());
        arrayListOf.add(this.mediaListItem.resetData(arrayList));
        arrayListOf.addAll(j());
        arrayListOf.addAll(l());
        return arrayListOf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0064, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r8, r3) != false) goto L18;
     */
    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.HWDetailMediaDataModel
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(@NotNull com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.a data, @Nullable Function0<Unit> callback) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) data, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        GroupSchoolTaskCheckInInfo a16 = data.a();
        GroupSchoolNoticeContent groupSchoolNoticeContent = a16.content;
        Intrinsics.checkNotNullExpressionValue(groupSchoolNoticeContent, "info.content");
        s(groupSchoolNoticeContent);
        this.userInfoTitleItem.setUin(String.valueOf(a16.uin));
        UserInfoTitleItem userInfoTitleItem = this.userInfoTitleItem;
        String str2 = a16.name;
        Intrinsics.checkNotNullExpressionValue(str2, "info.name");
        userInfoTitleItem.setName(str2);
        this.userInfoTitleItem.setMakeUp(a16.isMakeUp);
        UserInfoTitleItem userInfoTitleItem2 = this.userInfoTitleItem;
        boolean z16 = true;
        if (data.b().status == 1) {
            String valueOf = String.valueOf(a16.uin);
            AppInterface e16 = bg.e();
            if (e16 != null) {
                str = e16.getCurrentAccountUin();
            } else {
                str = null;
            }
        }
        z16 = false;
        userInfoTitleItem2.setShowMoreAction(z16);
        this.userInfoTitleItem.setSubTitle("\u53d1\u5e03\u4e8e " + new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR, Locale.getDefault()).format(new Date(a16.checkInTime * 1000)));
        if (callback != null) {
            callback.invoke();
        }
    }
}
