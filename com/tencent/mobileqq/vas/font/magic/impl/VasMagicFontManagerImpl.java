package com.tencent.mobileqq.vas.font.magic.impl;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.VipNtMMKV;
import com.tencent.mobileqq.vas.api.INtVipStatus;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.font.magic.IVasMagicFontManager;
import com.tencent.mobileqq.vas.font.magic.IVasMagicFontSetProxy;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.action.b;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0002 !B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u000f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\fH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\nH\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/vas/font/magic/impl/VasMagicFontManagerImpl;", "Lcom/tencent/mobileqq/vas/font/magic/IVasMagicFontManager;", "", "flag", "", "Lcom/tencent/mobileqq/vas/font/magic/impl/VasMagicFontManagerImpl$b;", "getTipsConfig", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDefConfig", "", "isCanAdd", "Lkotlin/Function1;", "", "callback", "disableMagicFontDress", "", "getClearKey", "getAddKey", "setFlag", "isDisableMagicFontType", "peerUid", "chatType", "checkAndTriggerLocalTips", "setClearMagicFlag", "hideGuestMagicFont", "Lcom/tencent/mobileqq/vas/font/magic/IVasMagicFontSetProxy;", "proxy", "Lcom/tencent/mobileqq/vas/font/magic/IVasMagicFontSetProxy;", "<init>", "()V", "Companion", "a", "b", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasMagicFontManagerImpl implements IVasMagicFontManager {
    private static final int CHECKED_DEF = 0;
    private static final int CHECKED_SET = 1;
    private static final int CHECKED_TIPS = 2;
    private static final boolean DEBUG = false;
    private static final long DELIST_MAGIC_FONT_GRAY_TIPS = 10481;
    private static final int FLAG_CHAODAZI = 1;
    private static final int FLAG_DAXIAOZI = 2;

    @NotNull
    private static final String KEY_ADD_LOCAL_MAGIC_FLAG = "key_add_local_magic_flag";

    @NotNull
    private static final String KEY_CLEAR_MAGIC_FLAG = "key_clear_magic_flag";

    @NotNull
    private static final String TAG = "VasMagicFontManagerImpl";

    @NotNull
    private static final UnitedProxy TOGGLE_DISABLE_SWITCH;
    private static final boolean TOGGLE_HIDE_GUEST_MAGICFONT;
    private static final boolean TOGGLE_OPEN;
    private static volatile int checked;

    @NotNull
    private final IVasMagicFontSetProxy proxy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/font/magic/impl/VasMagicFontManagerImpl$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "text", WadlProxyConsts.KEY_JUMP_URL, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.font.magic.impl.VasMagicFontManagerImpl$b, reason: from toString */
    /* loaded from: classes20.dex */
    public static final /* data */ class TipItem {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String text;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String jumpUrl;

        public TipItem(@NotNull String text, @NotNull String jumpUrl) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
            this.text = text;
            this.jumpUrl = jumpUrl;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TipItem)) {
                return false;
            }
            TipItem tipItem = (TipItem) other;
            if (Intrinsics.areEqual(this.text, tipItem.text) && Intrinsics.areEqual(this.jumpUrl, tipItem.jumpUrl)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.text.hashCode() * 31) + this.jumpUrl.hashCode();
        }

        @NotNull
        public String toString() {
            return "TipItem(text=" + this.text + ", jumpUrl=" + this.jumpUrl + ")";
        }

        public /* synthetic */ TipItem(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? "" : str2);
        }
    }

    static {
        ar.Companion companion = ar.INSTANCE;
        UnitedProxy b16 = companion.b("shouyouye", "2025-01-13", "vas_disable_offline_magicfont_switch");
        TOGGLE_DISABLE_SWITCH = b16;
        TOGGLE_OPEN = b16.isEnable(false);
        TOGGLE_HIDE_GUEST_MAGICFONT = companion.b("shouyouye", "2025-02-21", "vas_hide_guest_magicfont").isEnable(false);
    }

    public VasMagicFontManagerImpl() {
        QRouteApi api = QRoute.api(IVasMagicFontSetProxy.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IVasMagicFontSetProxy::class.java)");
        this.proxy = (IVasMagicFontSetProxy) api;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disableMagicFontDress(final Function1<? super Boolean, Unit> callback) {
        this.proxy.setMagicFont(0, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.vas.font.magic.impl.VasMagicFontManagerImpl$disableMagicFontDress$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                callback.invoke(Boolean.valueOf(z16));
            }
        });
    }

    private final String getAddKey() {
        return KEY_ADD_LOCAL_MAGIC_FLAG + MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
    }

    private final String getClearKey() {
        return KEY_CLEAR_MAGIC_FLAG + MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
    }

    private final ArrayList<TipItem> getDefConfig(int flag) {
        ArrayList<TipItem> arrayList = new ArrayList<>();
        int i3 = 2;
        String str = null;
        byte b16 = 0;
        byte b17 = 0;
        byte b18 = 0;
        byte b19 = 0;
        byte b26 = 0;
        if (flag == 1) {
            arrayList.add(new TipItem("\u8d85\u5927\u5b57\u4f53\u7279\u6548\u5df2\u4e0b\u7ebf\uff0c\u53bb", str, i3, b26 == true ? 1 : 0));
        } else {
            arrayList.add(new TipItem("\u5927\u5c0f\u5b57\u7279\u6548\u5df2\u4e0b\u7ebf\uff0c\u53bb", b17 == true ? 1 : 0, i3, b16 == true ? 1 : 0));
        }
        arrayList.add(new TipItem("\u67e5\u770b\u4e0b\u7ebf\u8865\u507f", "https://act.qzone.qq.com/v2/vip/tx/p/52265_a2b137af?enteranceId=moren&_wv=16777218"));
        arrayList.add(new TipItem("\uff0c\u8fd8\u53ef", b19 == true ? 1 : 0, i3, b18 == true ? 1 : 0));
        arrayList.add(new TipItem("\u514d\u8d39\u8bbe\u7f6e\u5b57\u4f53", "mqqapi://setting/font"));
        return arrayList;
    }

    private final List<TipItem> getTipsConfig(int flag) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject json = TOGGLE_DISABLE_SWITCH.getJson();
            if (flag == 1 && json.has("tips_big") && (optJSONArray2 = json.optJSONArray("tips_big")) != null) {
                int length = optJSONArray2.length();
                for (int i3 = 0; i3 < length; i3++) {
                    Object obj = optJSONArray2.get(i3);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                    JSONObject jSONObject = (JSONObject) obj;
                    String text = jSONObject.optString("text");
                    String jumpUrl = jSONObject.optString(WadlProxyConsts.KEY_JUMP_URL);
                    Intrinsics.checkNotNullExpressionValue(text, "text");
                    Intrinsics.checkNotNullExpressionValue(jumpUrl, "jumpUrl");
                    arrayList.add(new TipItem(text, jumpUrl));
                }
            }
            if (flag == 2 && json.has("tips_magic") && (optJSONArray = json.optJSONArray("tips_magic")) != null) {
                int length2 = optJSONArray.length();
                for (int i16 = 0; i16 < length2; i16++) {
                    Object obj2 = optJSONArray.get(i16);
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                    JSONObject jSONObject2 = (JSONObject) obj2;
                    String text2 = jSONObject2.optString("text");
                    String jumpUrl2 = jSONObject2.optString(WadlProxyConsts.KEY_JUMP_URL);
                    Intrinsics.checkNotNullExpressionValue(text2, "text");
                    Intrinsics.checkNotNullExpressionValue(jumpUrl2, "jumpUrl");
                    arrayList.add(new TipItem(text2, jumpUrl2));
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
        } catch (Exception e16) {
            QLog.i(TAG, 1, "getTipsConfig Error getting", e16);
        }
        return getDefConfig(flag);
    }

    private final boolean isCanAdd(int flag) {
        boolean z16;
        if (System.currentTimeMillis() < TOGGLE_DISABLE_SWITCH.getJson().optLong("deadline", 1767283199000L)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.i(TAG, 1, "is over deadline!");
            return false;
        }
        boolean isSVip = ((INtVipStatus) QRoute.api(INtVipStatus.class)).isSVip();
        QLog.i(TAG, 1, "isSVip: " + isSVip);
        if (!isSVip) {
            return false;
        }
        if (flag != 1) {
            return true;
        }
        IVasMagicFontSetProxy iVasMagicFontSetProxy = this.proxy;
        String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "sMobileQQ.peekAppRuntime().currentAccountUin");
        return iVasMagicFontSetProxy.isMaigcFontEnable(currentAccountUin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setFlag(int flag) {
        VipNtMMKV.Companion.getCommon$default(VipNtMMKV.INSTANCE, null, 1, null).encodeInt(getClearKey(), flag);
        QLog.i(TAG, 1, "set clear magic flag success");
    }

    @Override // com.tencent.mobileqq.vas.font.magic.IVasMagicFontManager
    public void checkAndTriggerLocalTips(@NotNull String peerUid, int chatType) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        if (!TOGGLE_OPEN) {
            QLog.i(TAG, 1, "checkAndTriggerLocalTips toggle close!");
            return;
        }
        if (checked != 0 && checked != 2) {
            checked = 2;
            VipNtMMKV.Companion companion = VipNtMMKV.INSTANCE;
            int decodeInt = VipNtMMKV.Companion.getCommon$default(companion, null, 1, null).decodeInt(getClearKey(), 0);
            if (decodeInt != 1 && decodeInt != 2) {
                QLog.i(TAG, 1, "no clear magic flag: " + decodeInt);
                return;
            }
            VipNtMMKV.Companion.getCommon$default(companion, null, 1, null).encodeInt(getClearKey(), 0);
            VipNtMMKV.Companion.getCommon$default(companion, null, 1, null).removeKey(getClearKey());
            if (!isCanAdd(decodeInt)) {
                return;
            }
            if (VipNtMMKV.Companion.getCommon$default(companion, null, 1, null).decodeInt(getAddKey(), 0) != 0) {
                QLog.i(TAG, 1, "\u5df2\u7ecf\u6dfb\u52a0\u8fc7\u4e00\u6b21\u4e86!");
                return;
            }
            QLog.i(TAG, 1, "checkAndTriggerLocalTips add local tips");
            LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder = new LocalGrayTip.LocalGrayTipBuilder(peerUid, chatType, DELIST_MAGIC_FONT_GRAY_TIPS, 0, false, false, null, 120, null);
            for (TipItem tipItem : getTipsConfig(decodeInt)) {
                if (TextUtils.isEmpty(tipItem.getJumpUrl())) {
                    LocalGrayTip.LocalGrayTipBuilder.i(localGrayTipBuilder, tipItem.getText(), 0, 2, null);
                } else {
                    localGrayTipBuilder.h(tipItem.getText(), new b(tipItem.getJumpUrl()), 3);
                }
            }
            QRouteApi api = QRoute.api(INtGrayTipApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(INtGrayTipApi::class.java)");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
            INtGrayTipApi.a.a((INtGrayTipApi) api, peekAppRuntime, localGrayTipBuilder.m(), null, 4, null);
            VipNtMMKV.Companion.getCommon$default(VipNtMMKV.INSTANCE, null, 1, null).encodeInt(getAddKey(), 1);
        }
    }

    @Override // com.tencent.mobileqq.vas.font.magic.IVasMagicFontManager
    public boolean hideGuestMagicFont() {
        return TOGGLE_HIDE_GUEST_MAGICFONT;
    }

    @Override // com.tencent.mobileqq.vas.font.magic.IVasMagicFontManager
    public boolean isDisableMagicFontType() {
        return TOGGLE_OPEN;
    }

    @Override // com.tencent.mobileqq.vas.font.magic.IVasMagicFontManager
    public void setClearMagicFlag() {
        if (!TOGGLE_OPEN) {
            QLog.i(TAG, 1, "checkAndTriggerLocalTips toggle close!");
            return;
        }
        if (checked >= 1) {
            return;
        }
        String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        IVasMagicFontSetProxy iVasMagicFontSetProxy = this.proxy;
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "currentAccountUin");
        String uidByUin = iVasMagicFontSetProxy.getUidByUin(currentAccountUin);
        QRouteApi api = QRoute.api(IVasInfoService.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IVasInfoService::class.java)");
        ((IVasInfoService) api).getVasInfoWithUid(uidByUin, TAG, new hx3.b<kx3.a>() { // from class: com.tencent.mobileqq.vas.font.magic.impl.VasMagicFontManagerImpl$setClearMagicFlag$1
            @Override // hx3.b
            public void onQueryResult(@Nullable e<kx3.a> responseData) {
                ArrayList<kx3.a> b16;
                VasMagicFontManagerImpl.checked = 1;
                if (responseData == null || (b16 = responseData.b()) == null || b16.isEmpty()) {
                    return;
                }
                kx3.a aVar = b16.get(0);
                Intrinsics.checkNotNullExpressionValue(aVar, "data[0]");
                final kx3.a aVar2 = aVar;
                if (aVar2.getMagicFont() != 1 && aVar2.getFontEffect() != 2000) {
                    QLog.i("VasMagicFontManagerImpl", 1, "\u6ca1\u6709\u5927\u5b57\u6216\u8005\u5927\u5c0f\u5b57\u7279\u6548");
                    return;
                }
                QLog.i("VasMagicFontManagerImpl", 1, "\u6709\u8d85\u5927\u5b57\u6216\u8005\u5927\u5c0f\u5b57\u7279\u6548, magicFont: " + aVar2.getMagicFont() + " magicFontType: " + aVar2.getFontEffect());
                final VasMagicFontManagerImpl vasMagicFontManagerImpl = VasMagicFontManagerImpl.this;
                vasMagicFontManagerImpl.disableMagicFontDress(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.vas.font.magic.impl.VasMagicFontManagerImpl$setClearMagicFlag$1$onQueryResult$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        if (z16) {
                            vasMagicFontManagerImpl.setFlag(kx3.a.this.getMagicFont() > 0 ? 2 : 1);
                        }
                    }
                });
            }
        });
    }
}
