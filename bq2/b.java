package bq2;

import Wallet.PfaFriend;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendFaceApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.transaction.IToPayManager;
import com.tencent.mobileqq.selectfriend.relationlist.SharedNode;
import com.tencent.mobileqq.selectfriend.relationlist.vm.ListType;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J,\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010\n\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0004\u0012\u00020\t0\u0006H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\bH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0004R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lbq2/b;", "Lcom/tencent/mobileqq/selectfriend/relationlist/model/a;", "Lcom/tencent/mobileqq/selectfriend/relationlist/vm/ListType;", "b", "", "fromNet", "Lkotlin/Function1;", "", "Lcom/tencent/mobileqq/selectfriend/relationlist/SharedNode;", "", "callback", "d", "sharedNode", "Landroid/graphics/drawable/Drawable;", "a", "", "uin", "Landroid/graphics/Bitmap;", "e", "", "I", "businessType", "businessSubType", "<init>", "(II)V", "c", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b extends com.tencent.mobileqq.selectfriend.relationlist.model.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int businessType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int businessSubType;

    public b(int i3, int i16) {
        this.businessType = i3;
        this.businessSubType = i16;
    }

    @Override // com.tencent.mobileqq.selectfriend.relationlist.model.a
    public Drawable a(SharedNode sharedNode) {
        Intrinsics.checkNotNullParameter(sharedNode, "sharedNode");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        BaseApplication context = BaseApplication.getContext();
        Object bizData = sharedNode.getBizData();
        Intrinsics.checkNotNull(bizData, "null cannot be cast to non-null type com.tencent.mobileqq.data.RecentUser");
        RecentUser recentUser = (RecentUser) bizData;
        if (recentUser.getType() == 10014) {
            return ((IQQGuildService) appInterface.getRuntimeService(IQQGuildService.class, "")).getAvatarDrawable(recentUser.troopUin, 100, null, true);
        }
        if (Intrinsics.areEqual(AppConstants.DATALINE_PC_UIN, sharedNode.getKey())) {
            return context.getResources().getDrawable(R.drawable.qfile_dataline_pc_recent);
        }
        if (recentUser.getType() == 1046) {
            return ((IMatchFriendFaceApi) QRoute.api(IMatchFriendFaceApi.class)).getMatchFriendFaceDrawable(appInterface, sharedNode.getKey());
        }
        Bitmap e16 = e(sharedNode.getKey());
        return e16 != null ? new BitmapDrawable(e16) : null;
    }

    @Override // com.tencent.mobileqq.selectfriend.relationlist.model.a
    public ListType b() {
        return ListType.NORMAL;
    }

    @Override // com.tencent.mobileqq.selectfriend.relationlist.model.a
    public void d(boolean fromNet, Function1<? super List<SharedNode>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ArrayList arrayList = null;
        HashMap<String, Object> topayList = ((IToPayManager) QRoute.api(IToPayManager.class)).getTopayList(null, fromNet, this.businessType, this.businessSubType);
        if (topayList == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Object obj = topayList.get("recommend");
        if (obj != null && (obj instanceof ArrayList)) {
            arrayList = (ArrayList) obj;
        }
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                PfaFriend pfaFriend = (PfaFriend) arrayList.get(i3);
                if (pfaFriend != null && !TextUtils.isEmpty(pfaFriend.uin)) {
                    arrayList2.add(com.tencent.mobileqq.selectfriend.relationlist.a.f285557a.h(new RecentUser(pfaFriend.uin, 0)));
                }
            }
        }
        callback.invoke(arrayList2);
    }

    protected final Bitmap e(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (!Intrinsics.areEqual(AppConstants.SEC_MSG_UIN, uin)) {
            return null;
        }
        try {
            return BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), R.drawable.f162141ft4);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }
}
