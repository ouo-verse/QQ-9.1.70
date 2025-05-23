package com.tencent.mobileqq.vas.gift;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.aio.msg.ai;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.qqnt.aio.adapter.api.IAIOAvatarApi;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ag;
import com.tencent.qqnt.kernel.nativeinterface.AvatarSize;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetUidInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.VASGiftCoinType;
import com.tencent.qqnt.kernelpublic.nativeinterface.TextGiftElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.VASGiftSpendCoinItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0007J3\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00142#\u0010\u001b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u0016R$\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u001dj\b\u0012\u0004\u0012\u00020\u0014`\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/vas/gift/g;", "", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/TextGiftElement;", "giftElement", "", "isShowPrice", "isShowCharm", "", "g", "", "sendType", "d", "uid", "Landroid/graphics/Bitmap;", "e", "f", "Lcom/tencent/aio/data/msglist/a;", "giftItem", "selfTinyId", "l", "", "uin", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "callback", tl.h.F, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "hasPlayList", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f309293a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<Long> hasPlayList = new ArrayList<>();

    g() {
    }

    private final String d(int sendType) {
        String str;
        if (sendType != 0 && sendType != 1) {
            if (sendType != 2) {
                if (sendType != 3) {
                    str = "";
                } else {
                    str = "pkgfree";
                }
            } else {
                str = "pkgpay";
            }
        } else {
            str = "common";
        }
        VasNtToggle vasNtToggle = VasNtToggle.INSTANCE;
        if (vasNtToggle.getVAS_TROOP_GIFT_ARK_LABLE_SHOW().isEnable(true)) {
            String stringDataSet = vasNtToggle.getVAS_TROOP_GIFT_ARK_LABLE_SHOW().getStringDataSet(str, "");
            if (stringDataSet == null) {
                return "";
            }
            return stringDataSet;
        }
        return "1";
    }

    private final Bitmap e(String uid) {
        boolean z16;
        String str;
        Bitmap decodeFile;
        boolean z17 = false;
        if (uid != null && uid.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        com.tencent.qqnt.kernel.api.h avatarService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getAvatarService();
        if (avatarService != null) {
            str = avatarService.getAvatarPath(uid, AvatarSize.SMALL);
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            z17 = true;
        }
        if (z17 || (decodeFile = BitmapFactory.decodeFile(str)) == null) {
            return null;
        }
        return BaseImageUtil.getRoundFaceBitmap(decodeFile, decodeFile.getWidth(), decodeFile.getHeight());
    }

    private final String g(TextGiftElement giftElement, boolean isShowPrice, boolean isShowCharm) {
        ArrayList<VASGiftSpendCoinItem> arrayList = giftElement.spendCoins;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<VASGiftSpendCoinItem> it = arrayList.iterator();
            long j3 = 0;
            long j16 = 0;
            while (it.hasNext()) {
                VASGiftSpendCoinItem next = it.next();
                VASGiftCoinType vASGiftCoinType = VASGiftCoinType.VASGIFTCOINTYPECOIN;
                if (vASGiftCoinType.ordinal() == next.coinType) {
                    j3 += next.amt;
                } else if (vASGiftCoinType.ordinal() == next.coinType) {
                    j16 += next.amt;
                }
            }
            long j17 = j3 + j16;
            if (isShowCharm && (j17 == 0 || !isShowPrice)) {
                return giftElement.charmValue + "\u9b45\u529b\u503c";
            }
            if (j3 == j3) {
                return j17 + "\u91d1\u5e01";
            }
            if (j17 == j16) {
                return j17 + "\u4ee3\u91d1\u5238";
            }
            if (j17 > 0) {
                return j17 + "\u91d1\u5e01";
            }
            return j17 + "\u91d1\u5e01";
        }
        return giftElement.price + "\u91d1\u5e01";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v8, types: [T, android.graphics.Bitmap] */
    public static final void i(final long j3, final Function1 callback) {
        boolean z16;
        HashSet<Long> hashSetOf;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IK\u2026va, ProcessConstant.MAIN)");
        ag uixConvertService = ((IKernelService) runtimeService).getUixConvertService();
        Intrinsics.checkNotNull(uixConvertService, "null cannot be cast to non-null type com.tencent.qqnt.kernel.api.IUixConvertService");
        String valueOf = String.valueOf(uixConvertService.u(j3));
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (valueOf.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || Intrinsics.areEqual(valueOf, "null")) {
            hashSetOf = SetsKt__SetsKt.hashSetOf(Long.valueOf(j3));
            uixConvertService.getUid(hashSetOf, new IKernelGetUidInfoCallback() { // from class: com.tencent.mobileqq.vas.gift.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetUidInfoCallback
                public final void onResult(HashMap hashMap) {
                    g.j(Ref.ObjectRef.this, j3, hashMap);
                }
            });
        } else {
            objectRef.element = f309293a.e(valueOf);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.gift.f
            @Override // java.lang.Runnable
            public final void run() {
                g.k(Function1.this, objectRef, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v3, types: [T, android.graphics.Bitmap] */
    public static final void j(Ref.ObjectRef bitmap, long j3, HashMap hashMap) {
        String str;
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        g gVar = f309293a;
        if (hashMap != null) {
            str = (String) hashMap.get(Long.valueOf(j3));
        } else {
            str = null;
        }
        bitmap.element = gVar.e(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void k(Function1 callback, Ref.ObjectRef bitmap, long j3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        Bitmap bitmap2 = (Bitmap) bitmap.element;
        if (bitmap2 == null) {
            bitmap2 = ((IAIOAvatarApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOAvatarApi.class)).getAvatar(String.valueOf(j3));
        }
        callback.invoke(bitmap2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0014. Please report as an issue. */
    @NotNull
    public final String f(@NotNull TextGiftElement giftElement) {
        Intrinsics.checkNotNullParameter(giftElement, "giftElement");
        String d16 = d(giftElement.sendType);
        if (d16 != null) {
            switch (d16.hashCode()) {
                case 49:
                    if (d16.equals("1")) {
                        return g(giftElement, true, true);
                    }
                    break;
                case 50:
                    if (d16.equals("2")) {
                        return g(giftElement, true, false);
                    }
                    break;
                case 51:
                    if (d16.equals("3")) {
                        return g(giftElement, false, true);
                    }
                    break;
            }
        }
        return g(giftElement, false, false);
    }

    public final void h(final long uin, @NotNull final Function1<? super Bitmap, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.gift.d
            @Override // java.lang.Runnable
            public final void run() {
                g.i(uin, callback);
            }
        }, 16, null, true);
    }

    public final boolean l(@NotNull com.tencent.aio.data.msglist.a giftItem, @NotNull String selfTinyId) {
        ai aiVar;
        Intrinsics.checkNotNullParameter(giftItem, "giftItem");
        Intrinsics.checkNotNullParameter(selfTinyId, "selfTinyId");
        if (giftItem instanceof ai) {
            aiVar = (ai) giftItem;
        } else {
            aiVar = null;
        }
        if (aiVar == null) {
            return false;
        }
        ArrayList<Long> arrayList = hasPlayList;
        if (!(!arrayList.contains(Long.valueOf(aiVar.getMsgRecord().msgId))) || TextUtils.isEmpty(selfTinyId)) {
            return false;
        }
        if (!arrayList.contains(Long.valueOf(aiVar.getMsgRecord().msgId))) {
            arrayList.add(Long.valueOf(aiVar.getMsgRecord().msgId));
        }
        TextGiftElement j26 = aiVar.j2();
        if (j26 == null || j26.level < 3) {
            return false;
        }
        boolean areEqual = Intrinsics.areEqual(selfTinyId, String.valueOf(j26.senderUin));
        boolean areEqual2 = Intrinsics.areEqual(selfTinyId, String.valueOf(j26.receiverUin));
        if (!areEqual && !areEqual2) {
            return false;
        }
        return true;
    }
}
