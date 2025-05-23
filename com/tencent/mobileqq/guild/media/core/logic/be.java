package com.tencent.mobileqq.guild.media.core.logic;

import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.api.RoleGroupUserUIData;
import com.tencent.mobileqq.guild.gift.module.k;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProSendGiftEventData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0007*\u00018\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\u000f\u0012\u0006\u00101\u001a\u00020.\u00a2\u0006\u0004\b<\u0010=J\u0016\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J \u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\tH\u0016J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0018\u0010!\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u000eH\u0016J\u0018\u0010#\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0005H\u0016J.\u0010(\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0014\u0010'\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\t0&H\u0016J\"\u0010-\u001a\u00020\t2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)2\b\u0010\u001f\u001a\u0004\u0018\u00010,H\u0016R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R,\u00105\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\t0&\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u001e\u00107\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/be;", "Lcom/tencent/mobileqq/guild/media/core/g;", "Lcom/tencent/mobileqq/guild/media/core/logic/gift/b;", "Lcom/tencent/mobileqq/guild/media/core/logic/h;", "Lcom/tencent/mobileqq/guild/gift/module/k;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSendGiftEventData;", "", "", "userIdList", "", "Y", "", "Lcom/tencent/mobileqq/guild/api/RoleGroupUserUIData;", "U", "", "isSelf", "giftAnimData", "isFree", "T", ExifInterface.LATITUDE_SOUTH, "P", BdhLogUtil.LogTag.Tag_Req, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "W", "E0", "h0", "u", "Lcom/tencent/mobileqq/app/QBaseFragment;", "qBaseFragment", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "data", "isFromPack", HippyTKDListViewAdapter.X, "originalData", "X", "guildId", "channelId", "Lkotlin/Function1;", "callback", "H", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "B", "Lcom/tencent/mobileqq/guild/media/core/f;", "e", "Lcom/tencent/mobileqq/guild/media/core/f;", "mediaChannelCore", "Ljava/lang/ref/WeakReference;", "f", "Ljava/lang/ref/WeakReference;", "weakGotoSelectGiftGivingUserCallback", tl.h.F, "weakReferenceQBaseFragment", "com/tencent/mobileqq/guild/media/core/logic/be$a", "i", "Lcom/tencent/mobileqq/guild/media/core/logic/be$a;", "mediaObserver", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class be extends h implements com.tencent.mobileqq.guild.media.core.logic.gift.b, com.tencent.mobileqq.guild.gift.module.k<IGProSendGiftEventData> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.f mediaChannelCore;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Function1<RoleGroupUserUIData, Unit>> weakGotoSelectGiftGivingUserCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<QBaseFragment> weakReferenceQBaseFragment;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mediaObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/be$a", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "", "", "userIdList", "", "isEnter", "", "r", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends com.tencent.mobileqq.guild.media.core.notify.y {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void r(@NotNull List<String> userIdList, boolean isEnter) {
            Intrinsics.checkNotNullParameter(userIdList, "userIdList");
            if (!isEnter) {
                be.this.Y(userIdList);
            }
        }
    }

    public be(@NotNull com.tencent.mobileqq.guild.media.core.f mediaChannelCore) {
        Intrinsics.checkNotNullParameter(mediaChannelCore, "mediaChannelCore");
        this.mediaChannelCore = mediaChannelCore;
        this.mediaObserver = new a();
    }

    private final void P(IGProSendGiftEventData giftAnimData) {
        com.tencent.mobileqq.guild.media.core.logic.gift.e eVar = com.tencent.mobileqq.guild.media.core.logic.gift.e.f228473a;
        if (eVar.f()) {
            QLog.i("MediaChannelSelectGift", 1, "handleChargeGift isFirstReceiveChargeGift");
            eVar.j(System.currentTimeMillis());
            Q(giftAnimData);
        }
    }

    private final void Q(IGProSendGiftEventData giftAnimData) {
        this.mediaChannelCore.o0().X().setValue(giftAnimData);
    }

    private final void R(IGProSendGiftEventData giftAnimData) {
        this.mediaChannelCore.o0().Y().setValue(giftAnimData);
    }

    private final void S(IGProSendGiftEventData giftAnimData) {
        com.tencent.mobileqq.guild.media.core.logic.gift.e eVar = com.tencent.mobileqq.guild.media.core.logic.gift.e.f228473a;
        if (eVar.g()) {
            QLog.i("MediaChannelSelectGift", 1, "handleFreeGift isFirstReceiveFreeGift");
            eVar.k(System.currentTimeMillis());
            R(giftAnimData);
        } else if (eVar.h()) {
            QLog.i("MediaChannelSelectGift", 1, "handleFreeGift isTodayFirstReceiveFreeGift");
            eVar.l(System.currentTimeMillis());
            W(giftAnimData);
        }
    }

    private final void T(boolean isSelf, IGProSendGiftEventData giftAnimData, boolean isFree) {
        if (!isSelf) {
            QLog.w("MediaChannelSelectGift", 1, "warn handleReceiveGiftTips receiver id: " + giftAnimData.getReceiverMember().getTinyId());
            return;
        }
        if (isFree) {
            S(giftAnimData);
        } else {
            P(giftAnimData);
        }
    }

    private final List<RoleGroupUserUIData> U() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, com.tencent.mobileqq.guild.media.core.data.p> entry : this.mediaChannelCore.o0().z().entrySet()) {
            RoleGroupUserUIData roleGroupUserUIData = new RoleGroupUserUIData(1);
            com.tencent.mobileqq.guild.media.core.data.p value = entry.getValue();
            String str = value.f228094b;
            Intrinsics.checkNotNullExpressionValue(str, "userInfo.name");
            roleGroupUserUIData.setName(str);
            String str2 = value.f228093a;
            Intrinsics.checkNotNullExpressionValue(str2, "userInfo.id");
            roleGroupUserUIData.setTinyId(str2);
            String str3 = value.f228094b;
            Intrinsics.checkNotNullExpressionValue(str3, "userInfo.name");
            roleGroupUserUIData.setTitleName(str3);
            arrayList.add(roleGroupUserUIData);
        }
        return arrayList;
    }

    private final void W(IGProSendGiftEventData giftAnimData) {
        this.mediaChannelCore.o0().c0().setValue(giftAnimData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(List<String> userIdList) {
        ConcurrentHashMap<String, com.tencent.mobileqq.guild.media.core.data.p> z16 = this.mediaChannelCore.o0().z();
        for (String str : userIdList) {
            if (z16.containsKey(str)) {
                z16.remove(str);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.gift.b
    public void B(int requestCode, int resultCode, @Nullable Intent data) {
        String[] strArr;
        String[] strArr2;
        Function1<RoleGroupUserUIData, Unit> function1;
        boolean z16;
        String str;
        if (requestCode == 999) {
            RoleGroupUserUIData roleGroupUserUIData = null;
            if (data != null) {
                strArr = data.getStringArrayExtra(IQQGuildRouterApi.SELECT_MEMBER_LIST);
            } else {
                strArr = null;
            }
            if (data != null) {
                strArr2 = data.getStringArrayExtra(IQQGuildRouterApi.SELECT_MEMBER_NAME_LIST);
            } else {
                strArr2 = null;
            }
            if (strArr != null) {
                if (strArr.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    if (strArr2 != null && strArr2.length == 1 && (str = strArr2[0]) != null) {
                        Intrinsics.checkNotNullExpressionValue(str, "memberNameList[0]");
                    } else {
                        str = "";
                    }
                    String tinyId = strArr[0];
                    RoleGroupUserUIData roleGroupUserUIData2 = new RoleGroupUserUIData(1);
                    Intrinsics.checkNotNullExpressionValue(tinyId, "tinyId");
                    roleGroupUserUIData2.setTinyId(tinyId);
                    roleGroupUserUIData2.setName(str);
                    roleGroupUserUIData2.setTitleName(str);
                    roleGroupUserUIData = roleGroupUserUIData2;
                }
            }
            WeakReference<Function1<RoleGroupUserUIData, Unit>> weakReference = this.weakGotoSelectGiftGivingUserCallback;
            if (weakReference != null && roleGroupUserUIData != null && (function1 = weakReference.get()) != null) {
                function1.invoke(roleGroupUserUIData);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        super.E0();
        this.mediaChannelCore.b0().h(this);
        com.tencent.mobileqq.guild.media.core.j.a().l0().b(this.mediaObserver);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.gift.b
    public void H(@NotNull String guildId, @NotNull String channelId, @NotNull Function1<? super RoleGroupUserUIData, Unit> callback) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        WeakReference<QBaseFragment> weakReference = this.weakReferenceQBaseFragment;
        if (weakReference != null) {
            this.weakGotoSelectGiftGivingUserCallback = new WeakReference<>(callback);
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openSingleMemberSelectorForAudioLiveOnline(weakReference.get(), guildId, channelId, U(), 999);
        }
    }

    @Override // com.tencent.mobileqq.guild.gift.module.k
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public void I(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a data, @NotNull IGProSendGiftEventData originalData) {
        boolean z16;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(originalData, "originalData");
        if (originalData.getGiftInfo().getSendType() != 3 && originalData.getGiftInfo().getGiftPrice() > 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        String str = this.mediaChannelCore.o0().getSelfUserInfo().f228093a;
        boolean areEqual = Intrinsics.areEqual(str, String.valueOf(originalData.getReceiverMember().getTinyId()));
        if (!Intrinsics.areEqual(str, String.valueOf(originalData.getSenderMember().getTinyId()))) {
            this.mediaChannelCore.o0().o().setValue(data);
        }
        T(areEqual, originalData, z16);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void h0() {
        super.h0();
    }

    @Override // com.tencent.mobileqq.guild.gift.module.k
    public void o() {
        k.a.a(this);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.gift.b
    public void q(@NotNull QBaseFragment qBaseFragment) {
        Intrinsics.checkNotNullParameter(qBaseFragment, "qBaseFragment");
        this.weakReferenceQBaseFragment = new WeakReference<>(qBaseFragment);
    }

    @Override // com.tencent.mobileqq.guild.gift.module.k
    public void s(int i3, @Nullable String str) {
        k.a.b(this, i3, str);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void u() {
        super.u();
        this.mediaChannelCore.b0().g(this);
        com.tencent.mobileqq.guild.media.core.j.a().l0().B(this.mediaObserver);
    }

    @Override // com.tencent.mobileqq.guild.gift.module.k
    public void x(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a data, boolean isFromPack) {
        Intrinsics.checkNotNullParameter(data, "data");
        ConcurrentHashMap<String, com.tencent.mobileqq.guild.media.core.data.p> z16 = this.mediaChannelCore.o0().z();
        if (!z16.containsKey(String.valueOf(data.f264920k))) {
            com.tencent.mobileqq.guild.media.core.data.p pVar = new com.tencent.mobileqq.guild.media.core.data.p();
            pVar.f228093a = String.valueOf(data.f264920k);
            pVar.f228094b = data.f264921l;
            pVar.f228095c = data.f264923n;
            z16.put(String.valueOf(data.f264920k), pVar);
        }
        this.mediaChannelCore.o0().o().setValue(data);
    }
}
