package com.tencent.sqshow.zootopia.nativeui.data;

import android.content.IntentFilter;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.cart.CartGoodsData;
import com.tencent.sqshow.zootopia.nativeui.data.cart.CartStatus;
import com.tencent.sqshow.zootopia.nativeui.data.cart.PriceType;
import com.tencent.sqshow.zootopia.nativeui.data.receiver.ZPlanAvatarH5EventReceiver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uv4.ak;
import uv4.al;
import uv4.az;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bX\u0010YJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\tJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u000bJ\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u001c\u0010\u0016\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00150\u000bJ\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0013j\b\u0012\u0004\u0012\u00020\u0017`\u0015J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019J\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000bJ\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u001fJ\u0014\u0010$\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020!0 J\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u000bJ\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u000bJ\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\u000bJ\u0006\u0010,\u001a\u00020+J\u0006\u0010-\u001a\u00020'J \u00100\u001a\u0012\u0012\u0004\u0012\u00020/0\u0013j\b\u0012\u0004\u0012\u00020/`\u00152\b\u0010.\u001a\u0004\u0018\u00010+J\u0006\u00101\u001a\u00020'J\f\u00102\u001a\b\u0012\u0004\u0012\u00020/0 J\u0006\u00103\u001a\u00020'J\u0017\u00105\u001a\u00020\t2\b\u00104\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b5\u00106J\u000e\u00108\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u000207J\u000e\u00109\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u000207R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020\t0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010;R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010;R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010;R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010;R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010;R*\u0010C\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00150\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010;R\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020\f0D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010ER\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010;R \u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010ER\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020%0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010;R&\u0010K\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0013j\b\u0012\u0004\u0012\u00020\u0017`\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010JR\u0016\u0010M\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010LR\u0016\u0010O\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010NR$\u0010P\u001a\u0012\u0012\u0004\u0012\u0002070\u0013j\b\u0012\u0004\u0012\u000207`\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010JR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020'0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010;R\u001a\u0010R\u001a\b\u0012\u0004\u0012\u00020)0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010;R\u0014\u0010T\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010SR\u0014\u0010W\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010V\u00a8\u0006Z"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/c;", "", "Luv4/ak;", "avatarData", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "G", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", DomainData.DOMAIN_NAME, "Lcom/tencent/sqshow/zootopia/utils/j;", "Lm94/a;", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "d", "w", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "l", "", HippyTKDListViewAdapter.X, "Lqu4/a;", "v", "u", "k", "Lcom/tencent/sqshow/zootopia/nativeui/data/cart/PriceType;", "o", "Landroidx/lifecycle/LiveData;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/cart/a;", tl.h.F, "list", "I", "Lcom/tencent/sqshow/zootopia/nativeui/data/cart/CartStatus;", "i", "", "r", "", "j", "Lcom/tencent/sqshow/zootopia/nativeui/data/l;", "y", "f", "pool", "Luv4/az;", "t", "B", ReportConstant.COSTREPORT_PREFIX, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "gender", "g", "(Ljava/lang/Integer;)Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "Lcom/tencent/sqshow/zootopia/nativeui/data/n;", "E", "H", "b", "Lcom/tencent/sqshow/zootopia/utils/j;", "mActiveSavedDressInfo", "c", "mActiveSavedGender", "mCurrentDressInfo", "mSavedDressInfo", "mDefaultDressInfo", "mInitDressInfo", "mCurrentDressIds", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "mCurrentAdapter", "mCurrentPriceType", "mCurrentCartData", "mCurrentCartStatus", "Ljava/util/HashSet;", "mAllSlotSet", "Luv4/ak;", "mAvatarData", "Z", "mInitStatus", "mListenerPool", "mItemBuySucceedNotify", "mAIGCCouponBuySucceedNotify", "Lcom/tencent/sqshow/zootopia/nativeui/data/l;", "mStoreItemPool", "Lcom/tencent/sqshow/zootopia/nativeui/data/receiver/ZPlanAvatarH5EventReceiver;", "Lcom/tencent/sqshow/zootopia/nativeui/data/receiver/ZPlanAvatarH5EventReceiver;", "mReceiver", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f370920a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.sqshow.zootopia.utils.j<m94.a> mActiveSavedDressInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.sqshow.zootopia.utils.j<UEAvatarGender> mActiveSavedGender;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.sqshow.zootopia.utils.j<m94.a> mCurrentDressInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.sqshow.zootopia.utils.j<m94.a> mSavedDressInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.sqshow.zootopia.utils.j<m94.a> mDefaultDressInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.sqshow.zootopia.utils.j<m94.a> mInitDressInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.sqshow.zootopia.utils.j<HashSet<String>> mCurrentDressIds;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final MutableLiveData<m94.a> mCurrentAdapter;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.sqshow.zootopia.utils.j<PriceType> mCurrentPriceType;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static final MutableLiveData<List<CartGoodsData>> mCurrentCartData;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.sqshow.zootopia.utils.j<CartStatus> mCurrentCartStatus;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static HashSet<Integer> mAllSlotSet;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private static ak mAvatarData;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private static boolean mInitStatus;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private static final HashSet<n> mListenerPool;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.sqshow.zootopia.utils.j<Boolean> mItemBuySucceedNotify;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.sqshow.zootopia.utils.j<Long> mAIGCCouponBuySucceedNotify;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private static final l mStoreItemPool;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private static final ZPlanAvatarH5EventReceiver mReceiver;

    static {
        List emptyList;
        int i3 = 7;
        mActiveSavedDressInfo = new com.tencent.sqshow.zootopia.utils.j<>(null, new m94.a(null, null, null, i3, null), "mActiveSavedDressInfo", 1, 0 == true ? 1 : 0);
        MutableLiveData mutableLiveData = null;
        int i16 = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        mActiveSavedGender = new com.tencent.sqshow.zootopia.utils.j<>(mutableLiveData, UEAvatarGender.MALE, "mActiveSavedGender", i16, defaultConstructorMarker);
        mCurrentDressInfo = new com.tencent.sqshow.zootopia.utils.j<>(0 == true ? 1 : 0, new m94.a(null, null, 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0), "mCurrentDressInfo", 1, 0 == true ? 1 : 0);
        mSavedDressInfo = new com.tencent.sqshow.zootopia.utils.j<>(mutableLiveData, new m94.a(0 == true ? 1 : 0, null, null, 7, 0 == true ? 1 : 0), "mSavedDressInfo", i16, defaultConstructorMarker);
        byte b16 = 0 == true ? 1 : 0;
        byte b17 = 0 == true ? 1 : 0;
        mDefaultDressInfo = new com.tencent.sqshow.zootopia.utils.j<>(0 == true ? 1 : 0, new m94.a(0 == true ? 1 : 0, null, b16, i3, b17), "mDefaultDressInfo", 1, 0 == true ? 1 : 0);
        mInitDressInfo = new com.tencent.sqshow.zootopia.utils.j<>(mutableLiveData, new m94.a(0 == true ? 1 : 0, null, null, 7, 0 == true ? 1 : 0), "mInitDressInfo", i16, defaultConstructorMarker);
        mCurrentDressIds = new com.tencent.sqshow.zootopia.utils.j<>(0 == true ? 1 : 0, new HashSet(), "mCurrentDressIds", 1, 0 == true ? 1 : 0);
        mCurrentAdapter = new MutableLiveData<>();
        mCurrentPriceType = new com.tencent.sqshow.zootopia.utils.j<>(0 == true ? 1 : 0, PriceType.SILVER_FIRST, null, 5, 0 == true ? 1 : 0);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        mCurrentCartData = new MutableLiveData<>(emptyList);
        mCurrentCartStatus = new com.tencent.sqshow.zootopia.utils.j<>(null, CartStatus.NORMAL, null, 5, null);
        mAllSlotSet = new HashSet<>();
        mAvatarData = new ak();
        mListenerPool = new HashSet<>();
        mItemBuySucceedNotify = new com.tencent.sqshow.zootopia.utils.j<>(null, Boolean.FALSE, null, 5, null);
        mAIGCCouponBuySucceedNotify = new com.tencent.sqshow.zootopia.utils.j<>(0 == true ? 1 : 0, -1L, null, 5, null);
        mStoreItemPool = new l();
        mReceiver = new ZPlanAvatarH5EventReceiver();
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.data.a
            @Override // java.lang.Runnable
            public final void run() {
                c.c();
            }
        });
    }

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(ak avatarData) {
        Intrinsics.checkNotNullParameter(avatarData, "$avatarData");
        Iterator<T> it = mListenerPool.iterator();
        while (it.hasNext()) {
            ((n) it.next()).c7(avatarData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        BaseApplication baseApplication = BaseApplication.context;
        IntentFilter intentFilter = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        if (baseApplication != null) {
            try {
                baseApplication.registerReceiver(mReceiver, intentFilter);
            } catch (Exception e16) {
                QLog.e("AvatarDataCenter_", 1, "registerReceiver failed!", e16);
            }
        }
    }

    public final boolean A() {
        return r94.a.a(mCurrentDressInfo.b().getAvatarCharacter(), mActiveSavedDressInfo.b().getAvatarCharacter());
    }

    public final boolean B() {
        com.tencent.sqshow.zootopia.utils.j<m94.a> jVar = mCurrentDressInfo;
        UEAvatarGender gender = jVar.b().getGender();
        UEAvatarGender b16 = mActiveSavedGender.b();
        if (gender != b16) {
            QLog.d("AvatarDataCenter_", 1, "currentInfoGender:" + gender + ", savedGender:" + b16);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z16 = !r94.a.c(jVar.b().getAvatarCharacter(), mActiveSavedDressInfo.b().getAvatarCharacter());
        QLog.d("AvatarDataCenter_", 4, "currentCharacter and savedCharacter isChanged :" + z16 + " cost: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return z16;
    }

    public final void C(final ak avatarData) {
        Intrinsics.checkNotNullParameter(avatarData, "avatarData");
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.data.b
            @Override // java.lang.Runnable
            public final void run() {
                c.D(ak.this);
            }
        }, 10L);
    }

    public final void E(n l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        mListenerPool.add(l3);
        if (mInitStatus) {
            l3.c7(mAvatarData);
        }
    }

    public final void G() {
        mStoreItemPool.a();
    }

    public final void H(n l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        mListenerPool.remove(l3);
    }

    public final void I(List<CartGoodsData> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        mCurrentCartData.setValue(list);
    }

    public final com.tencent.sqshow.zootopia.utils.j<m94.a> d() {
        return mActiveSavedDressInfo;
    }

    public final com.tencent.sqshow.zootopia.utils.j<UEAvatarGender> e() {
        return mActiveSavedGender;
    }

    public final boolean f() {
        return mInitStatus;
    }

    public final UEAvatarGender g(Integer gender) {
        UEAvatarGender uEAvatarGender = UEAvatarGender.MALE;
        int index = uEAvatarGender.getIndex();
        if (gender != null && gender.intValue() == index) {
            return uEAvatarGender;
        }
        UEAvatarGender uEAvatarGender2 = UEAvatarGender.FEMALE;
        return (gender != null && gender.intValue() == uEAvatarGender2.getIndex()) ? uEAvatarGender2 : uEAvatarGender;
    }

    public final LiveData<List<CartGoodsData>> h() {
        return mCurrentCartData;
    }

    public final com.tencent.sqshow.zootopia.utils.j<CartStatus> i() {
        return mCurrentCartStatus;
    }

    public final com.tencent.sqshow.zootopia.utils.j<Long> j() {
        return mAIGCCouponBuySucceedNotify;
    }

    public final qu4.a k() {
        com.tencent.sqshow.zootopia.utils.j<m94.a> jVar = mCurrentDressInfo;
        if (jVar.c()) {
            return jVar.b().getAvatarCharacter();
        }
        return null;
    }

    public final com.tencent.sqshow.zootopia.utils.j<HashSet<String>> l() {
        return mCurrentDressIds;
    }

    public final com.tencent.sqshow.zootopia.utils.j<m94.a> m() {
        return mCurrentDressInfo;
    }

    public final UEAvatarGender n() {
        return m().b().getGender();
    }

    public final com.tencent.sqshow.zootopia.utils.j<PriceType> o() {
        return mCurrentPriceType;
    }

    public final com.tencent.sqshow.zootopia.utils.j<m94.a> p() {
        return mDefaultDressInfo;
    }

    public final com.tencent.sqshow.zootopia.utils.j<m94.a> q() {
        return mInitDressInfo;
    }

    public final com.tencent.sqshow.zootopia.utils.j<Boolean> r() {
        return mItemBuySucceedNotify;
    }

    public final List<az> s() {
        List<az> emptyList;
        Object obj;
        Collection<az> values = mCurrentDressInfo.b().b().values();
        Collection<az> values2 = mActiveSavedDressInfo.b().b().values();
        if (values.isEmpty() || values2.isEmpty()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : values2) {
            az azVar = (az) obj2;
            Iterator<T> it = values.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((az) obj).f440275b == azVar.f440275b) {
                    break;
                }
            }
            if (obj == null) {
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }

    public final HashSet<az> t(l pool) {
        az value;
        HashSet<az> hashSet = new HashSet<>();
        for (Map.Entry<Integer, az> entry : mCurrentDressInfo.b().b().entrySet()) {
            if (pool == null || (value = pool.b(entry.getValue())) == null) {
                value = entry.getValue();
            }
            if (com.tencent.sqshow.zootopia.nativeui.data.cart.b.a(value, true)) {
                hashSet.add(value);
            }
        }
        return hashSet;
    }

    public final qu4.a u() {
        com.tencent.sqshow.zootopia.utils.j<m94.a> jVar = mActiveSavedDressInfo;
        if (jVar.c()) {
            return jVar.b().getAvatarCharacter();
        }
        return null;
    }

    public final qu4.a v() {
        com.tencent.sqshow.zootopia.utils.j<m94.a> jVar = mSavedDressInfo;
        if (jVar.c()) {
            return jVar.b().getAvatarCharacter();
        }
        return null;
    }

    public final com.tencent.sqshow.zootopia.utils.j<m94.a> w() {
        return mSavedDressInfo;
    }

    public final HashSet<Integer> x() {
        return mAllSlotSet;
    }

    public final l y() {
        return mStoreItemPool;
    }

    public final void z(ak avatarData) {
        m94.a aVar;
        m94.a aVar2;
        m94.a aVar3;
        Intrinsics.checkNotNullParameter(avatarData, "avatarData");
        mAvatarData = avatarData;
        UEAvatarGender g16 = g(Integer.valueOf(avatarData.f440145a));
        UEAvatarGender g17 = g(Integer.valueOf(avatarData.f440149e));
        al alVar = avatarData.f440147c;
        if (alVar == null || (aVar = r94.b.O(alVar, g16, mAllSlotSet)) == null) {
            aVar = new m94.a(null, null, null, 7, null);
        }
        al alVar2 = avatarData.f440148d;
        if (alVar2 == null || (aVar2 = r94.b.O(alVar2, g16, mAllSlotSet)) == null) {
            aVar2 = new m94.a(null, null, null, 7, null);
        }
        al alVar3 = avatarData.f440146b;
        if (alVar3 == null || (aVar3 = r94.b.O(alVar3, g16, mAllSlotSet)) == null) {
            aVar3 = new m94.a(null, null, null, 7, null);
        }
        mDefaultDressInfo.e(aVar);
        mInitDressInfo.e(aVar2);
        if (g16 == g17) {
            mActiveSavedDressInfo.e(aVar3);
        }
        mCurrentDressInfo.e(aVar3);
        mSavedDressInfo.e(aVar3);
        mActiveSavedGender.e(g17);
        mInitStatus = true;
        C(avatarData);
        QLog.i("AvatarDataCenter_", 1, "initAvatarData done, defaultDressInfo=" + aVar + ",initDressInfo=" + aVar2 + ",currentDressInfo=" + aVar3);
    }

    public final void F() {
        List<CartGoodsData> emptyList;
        QLog.i("AvatarDataCenter_", 1, "reset");
        mInitStatus = false;
        mAvatarData = new ak();
        MutableLiveData<List<CartGoodsData>> mutableLiveData = mCurrentCartData;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        mutableLiveData.setValue(emptyList);
        mCurrentDressIds.d();
        mDefaultDressInfo.d();
        mInitDressInfo.d();
        mActiveSavedDressInfo.d();
        mSavedDressInfo.d();
        mCurrentDressInfo.d();
        mStoreItemPool.a();
    }
}
