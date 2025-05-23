package dk4;

import android.graphics.Color;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.ark.ark;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.user.UserCardInfo;
import com.tencent.mobileqq.qqlive.sail.SailAudienceRoomManager;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.profile.data.UserFileds;
import com.tencent.timi.game.liveroom.impl.room.userlevel.bean.UserLevelToggle;
import com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper;
import dk4.d;
import ek4.PayLevelEnterRoomInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import sr4.g;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001d2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b1\u00102J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0013\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u000e\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0006J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u001e\u001a\u00020\fR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010&R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b)\u0010+R\u0016\u0010.\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010/\u00a8\u00063"}, d2 = {"Ldk4/a;", "Ldk4/d$b;", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData$SpeakerInfo;", "audienceInfo", "Lek4/a;", "i", "", "uid", "", "name", ark.ARKMETADATA_JSON, "j", "", "l", "", "fromFloatWindow", "k", "Lcom/tencent/mobileqq/qqlive/data/user/UserCardInfo;", "liveUserInfo", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", "onAudienceEnterRoom", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "msg", "onGiftMessageReceive", "roomId", "f", "enterRoomId", "g", h.F, "Ldk4/d;", "a", "Ldk4/d;", "pushMgr", "b", "J", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "_enterRoomInfo", "Landroidx/lifecycle/LiveData;", "d", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "enterRoomInfo", "Z", "configUpdate", "Lcom/tencent/mobileqq/qqlive/data/user/UserCardInfo;", "userCardInfo", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a implements d.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d pushMgr = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long roomId = -1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<PayLevelEnterRoomInfo> _enterRoomInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<PayLevelEnterRoomInfo> enterRoomInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean configUpdate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private UserCardInfo userCardInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"dk4/a$b", "Lfl4/a;", "Lel4/a;", "userCardInfo", "", "a", "", "errorCode", "", "errorMsg", "onFailed", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends fl4.a {
        b() {
        }

        @Override // fl4.a
        public void a(@Nullable el4.a userCardInfo) {
            Long l3;
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            String str = null;
            if (userCardInfo != null) {
                l3 = Long.valueOf(userCardInfo.uid);
            } else {
                l3 = null;
            }
            if (userCardInfo != null) {
                str = userCardInfo.nick;
            }
            companion.d("unknown|PayLevelEnterRoomBubbleLogic", "pullSelfEnterRoomInfo", "onSuccess, uid:" + l3 + ", nick:" + str);
            a.this.userCardInfo = userCardInfo;
            a.this.c(userCardInfo);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.BaseCallback
        public void onFailed(int errorCode, @Nullable String errorMsg) {
            AegisLogger.INSTANCE.d("unknown|PayLevelEnterRoomBubbleLogic", "pullSelfEnterRoomInfo", "error, code:" + errorCode + ", msg:" + errorMsg);
        }
    }

    public a() {
        MutableLiveData<PayLevelEnterRoomInfo> mutableLiveData = new MutableLiveData<>();
        this._enterRoomInfo = mutableLiveData;
        this.enterRoomInfo = mutableLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void c(UserCardInfo liveUserInfo) {
        boolean z16;
        boolean z17;
        boolean isBlank;
        boolean z18;
        boolean z19;
        boolean z26;
        if (liveUserInfo != null && this.configUpdate) {
            if (BusConfigHelper.f378723a.f(15, this.roomId)) {
                AegisLogger.INSTANCE.d("unknown|PayLevelEnterRoomBubbleLogic", "insertSelfEnterRoomInfo", "config block");
                return;
            }
            List<g> list = liveUserInfo.medalInfoNews;
            boolean z27 = false;
            if (list != null) {
                for (g gVar : list) {
                    String str = gVar.f434408z;
                    Intrinsics.checkNotNullExpressionValue(str, "it.diamondMedalBgImg");
                    isBlank = StringsKt__StringsJVMKt.isBlank(str);
                    if (!isBlank) {
                        AegisLogger.INSTANCE.i("unknown|PayLevelEnterRoomBubbleLogic", "insertSelfEnterRoomInfo", "diamond_group_info={tips=" + liveUserInfo.enterRoomTips + ", iconImg=" + gVar.f434387c + ", bgImg=" + gVar.f434403s);
                        String str2 = liveUserInfo.enterRoomTips;
                        if (str2 != null && str2.length() != 0) {
                            z18 = false;
                        } else {
                            z18 = true;
                        }
                        if (z18) {
                            continue;
                        } else {
                            String str3 = gVar.f434387c;
                            if (str3 != null && str3.length() != 0) {
                                z19 = false;
                            } else {
                                z19 = true;
                            }
                            if (z19) {
                                continue;
                            } else {
                                String str4 = gVar.A;
                                if (str4 != null && str4.length() != 0) {
                                    z26 = false;
                                } else {
                                    z26 = true;
                                }
                                if (!z26) {
                                    MutableLiveData<PayLevelEnterRoomInfo> mutableLiveData = this._enterRoomInfo;
                                    long j3 = liveUserInfo.uid;
                                    String str5 = liveUserInfo.enterRoomTips;
                                    Intrinsics.checkNotNullExpressionValue(str5, "liveUserInfo.enterRoomTips");
                                    String str6 = gVar.f434387c;
                                    Intrinsics.checkNotNullExpressionValue(str6, "it.medalFaceSmall");
                                    String str7 = gVar.A;
                                    Intrinsics.checkNotNullExpressionValue(str7, "it.diamondFloatBarBgImg");
                                    c.b(mutableLiveData, new PayLevelEnterRoomInfo(j3, str5, -1L, str6, str7, true, 24.0f, 18.0f, 0L, 0L, 0L, 0, 3840, null));
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            List<g> list2 = liveUserInfo.medalInfoNews;
            g gVar2 = null;
            if (list2 != null) {
                Iterator<T> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((g) next).f434388d == 7) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        gVar2 = next;
                        break;
                    }
                }
                gVar2 = gVar2;
            }
            if (gVar2 == null) {
                AegisLogger.INSTANCE.d("unknown|PayLevelEnterRoomBubbleLogic", "insertSelfEnterRoomInfo", "medalInfo is null ");
                return;
            }
            String enterRoomTips = liveUserInfo.enterRoomTips;
            long j16 = gVar2.f434397m;
            String medalFaceSmall = gVar2.f434387c;
            String medalBgImg = gVar2.f434403s;
            AegisLogger.INSTANCE.i("unknown|PayLevelEnterRoomBubbleLogic", "insertSelfEnterRoomInfo", "enterRoomTips:" + enterRoomTips + ", medalLevel:" + j16 + ", medalFaceSmall:" + medalFaceSmall + ", medalBgImg:" + medalBgImg);
            if (enterRoomTips != null && enterRoomTips.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && j16 != 0) {
                if (medalFaceSmall == null || medalFaceSmall.length() == 0) {
                    z27 = true;
                }
                if (!z27) {
                    MutableLiveData<PayLevelEnterRoomInfo> mutableLiveData2 = this._enterRoomInfo;
                    long j17 = liveUserInfo.uid;
                    Intrinsics.checkNotNullExpressionValue(enterRoomTips, "enterRoomTips");
                    Intrinsics.checkNotNullExpressionValue(medalFaceSmall, "medalFaceSmall");
                    Intrinsics.checkNotNullExpressionValue(medalBgImg, "medalBgImg");
                    c.b(mutableLiveData2, new PayLevelEnterRoomInfo(j17, enterRoomTips, j16, medalFaceSmall, medalBgImg, true, 0.0f, 0.0f, 0L, 0L, 0L, 0, 4032, null));
                    return;
                }
                return;
            }
            return;
        }
        AegisLogger.INSTANCE.d("unknown|PayLevelEnterRoomBubbleLogic", "insertSelfEnterRoomInfo", "liveUserInfo is " + liveUserInfo + ", configUpdate:" + this.configUpdate);
    }

    private final boolean e() {
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        if (cVar.d().t()) {
            return false;
        }
        return SailAudienceRoomManager.D(cVar.m(), this.roomId, 0, 2, null);
    }

    private final PayLevelEnterRoomInfo i(LiveMessageData.SpeakerInfo audienceInfo) {
        it3.b bVar;
        boolean z16;
        if (audienceInfo.mSpeakId == com.tencent.mobileqq.qqlive.sail.c.f272176a.G()) {
            AegisLogger.INSTANCE.d("unknown|PayLevelEnterRoomBubbleLogic", "parseEnterRoomBubbleInfo", "self come from push ");
            return null;
        }
        byte[] bArr = audienceInfo.mBusinessData;
        if (bArr == null) {
            AegisLogger.INSTANCE.d("unknown|PayLevelEnterRoomBubbleLogic", "parseEnterRoomBubbleInfo", "businessDataBytes is null ");
            return null;
        }
        try {
            it3.b[] bVarArr = it3.a.c(bArr).f408722a;
            Intrinsics.checkNotNullExpressionValue(bVarArr, "businessDataContent.rptMsgDataItem");
            int length = bVarArr.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    bVar = bVarArr[i3];
                    if (bVar.f408724a == 37) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                    i3++;
                } else {
                    bVar = null;
                    break;
                }
            }
            if (bVar == null) {
                AegisLogger.INSTANCE.d("unknown|PayLevelEnterRoomBubbleLogic", "parseEnterRoomBubbleInfo", "dataItem is null ");
                return null;
            }
            String str = bVar.f408725b;
            AegisLogger.INSTANCE.d("unknown|PayLevelEnterRoomBubbleLogic", "parseEnterRoomBubbleInfo", "json:" + str);
            long j3 = audienceInfo.mSpeakId;
            String str2 = audienceInfo.mSpeakerName;
            Intrinsics.checkNotNullExpressionValue(str2, "audienceInfo.mSpeakerName");
            return j(j3, str2, str);
        } catch (InvalidProtocolBufferNanoException e16) {
            AegisLogger.INSTANCE.e("unknown|PayLevelEnterRoomBubbleLogic", "parseEnterRoomBubbleInfo", "error, ", e16);
            return null;
        }
    }

    private final PayLevelEnterRoomInfo j(long uid, String name, String json) {
        String str;
        String str2;
        long j3;
        boolean z16;
        boolean isBlank;
        boolean isBlank2;
        boolean isBlank3;
        if (json == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(json);
            JSONObject optJSONObject = jSONObject.optJSONObject("diamond_group_info");
            boolean z17 = true;
            if (optJSONObject != null) {
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "optJSONObject(\"diamond_group_info\")");
                String tips = jSONObject.optString("enter_room_tips");
                String iconImg = optJSONObject.optString("diamond_group_face_small");
                String bgImg = optJSONObject.optString("diamond_group_float_bar_bg_img");
                AegisLogger.INSTANCE.i("unknown|PayLevelEnterRoomBubbleLogic", "parseJson", "diamond_group_info={tips=" + tips + ", iconImg=" + iconImg + ", bgImg=" + bgImg);
                Intrinsics.checkNotNullExpressionValue(iconImg, "iconImg");
                isBlank = StringsKt__StringsJVMKt.isBlank(iconImg);
                if (!isBlank) {
                    Intrinsics.checkNotNullExpressionValue(tips, "tips");
                    isBlank2 = StringsKt__StringsJVMKt.isBlank(tips);
                    if (!isBlank2) {
                        Intrinsics.checkNotNullExpressionValue(bgImg, "bgImg");
                        isBlank3 = StringsKt__StringsJVMKt.isBlank(bgImg);
                        if (!isBlank3) {
                            return new PayLevelEnterRoomInfo(uid, tips, -1L, iconImg, bgImg, false, 24.0f, 18.0f, 0L, 0L, 0L, 0, 3840, null);
                        }
                    }
                }
            }
            JSONObject jSONObject2 = new JSONObject(json);
            String optString = jSONObject2.optString("enter_room_tips");
            Intrinsics.checkNotNullExpressionValue(optString, "optString(\"enter_room_tips\")");
            JSONObject optJSONObject2 = jSONObject2.optJSONObject("pay_level_info");
            if (optJSONObject2 != null) {
                Intrinsics.checkNotNullExpressionValue(optJSONObject2, "optJSONObject(\"pay_level_info\")");
                long optLong = optJSONObject2.optLong("pay_level");
                String optString2 = optJSONObject2.optString("pay_level_icon");
                Intrinsics.checkNotNullExpressionValue(optString2, "it.optString(\"pay_level_icon\")");
                String optString3 = optJSONObject2.optString("pay_level_bg_img");
                Intrinsics.checkNotNullExpressionValue(optString3, "it.optString(\"pay_level_bg_img\")");
                str2 = optString3;
                str = optString2;
                j3 = optLong;
            } else {
                str = "";
                str2 = str;
                j3 = 0;
            }
            if (optString.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && j3 != 0) {
                if (str.length() != 0) {
                    z17 = false;
                }
                if (!z17) {
                    return new PayLevelEnterRoomInfo(uid, optString, j3, str, str2, false, 0.0f, 0.0f, 0L, 0L, 0L, 0, 4064, null);
                }
            }
            return null;
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("unknown|PayLevelEnterRoomBubbleLogic", "parseJson", "error ", e16);
            return null;
        }
    }

    private final void k(boolean fromFloatWindow) {
        ArrayList arrayListOf;
        AegisLogger.INSTANCE.d("unknown|PayLevelEnterRoomBubbleLogic", "pullSelfEnterRoomInfo", "fromFloatWindow:" + fromFloatWindow);
        if (fromFloatWindow) {
            return;
        }
        long j3 = this.roomId;
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        long G = cVar.G();
        long l3 = com.tencent.mobileqq.qqlive.sail.c.l(cVar, this.roomId, 0, 2, null);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(UserFileds.Fileds_MEDAL, UserFileds.Fileds_Enter_Room_Tips);
        dl4.b.c(j3, G, l3, arrayListOf, new b());
    }

    private final void l() {
        this.pushMgr.d(this.roomId, this);
    }

    private final void m() {
        this.pushMgr.e();
    }

    @NotNull
    public final LiveData<PayLevelEnterRoomInfo> d() {
        return this.enterRoomInfo;
    }

    public final void f(long roomId) {
        this.configUpdate = true;
        c(this.userCardInfo);
    }

    public final void g(long enterRoomId, boolean fromFloatWindow) {
        if (!UserLevelToggle.INSTANCE.b()) {
            AegisLogger.INSTANCE.i("unknown|PayLevelEnterRoomBubbleLogic", "onEnterRoom", "toggle closed ");
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.d("unknown|PayLevelEnterRoomBubbleLogic", "onEnterRoom", "enterRoomId:" + enterRoomId);
        this.roomId = enterRoomId;
        if (enterRoomId == -1) {
            companion.e("unknown|PayLevelEnterRoomBubbleLogic", "onEnterRoom", "invalid room id");
            return;
        }
        if (e()) {
            companion.i("unknown|PayLevelEnterRoomBubbleLogic", "onEnterRoom", "roomId=" + this.roomId + ", has goods");
            return;
        }
        k(fromFloatWindow);
        l();
    }

    public final void h() {
        if (!UserLevelToggle.INSTANCE.b()) {
            AegisLogger.INSTANCE.i("unknown|PayLevelEnterRoomBubbleLogic", "onExitRoom", "toggle closed ");
            return;
        }
        if (e()) {
            AegisLogger.INSTANCE.d("unknown|PayLevelEnterRoomBubbleLogic", "onExitRoom", "roomId:" + this.roomId + ", has goods ");
            return;
        }
        AegisLogger.INSTANCE.d("unknown|PayLevelEnterRoomBubbleLogic", "onExitRoom", "roomId:" + this.roomId);
        if (this.roomId != -1) {
            m();
        }
        this.roomId = -1L;
        this.configUpdate = false;
    }

    @Override // dk4.d.b
    public void onAudienceEnterRoom(@NotNull LiveMessageData.SpeakerInfo audienceInfo) {
        Intrinsics.checkNotNullParameter(audienceInfo, "audienceInfo");
        AegisLogger.INSTANCE.d("unknown|PayLevelEnterRoomBubbleLogic", "onAudienceEnterRoom ");
        PayLevelEnterRoomInfo i3 = i(audienceInfo);
        if (i3 != null) {
            c.b(this._enterRoomInfo, i3);
        }
    }

    @Override // dk4.d.b
    public void onGiftMessageReceive(@NotNull GiftMessage msg2) {
        boolean z16;
        boolean isBlank;
        boolean isBlank2;
        boolean isBlank3;
        boolean z17;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        String str = msg2.liveExtMsg;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        AegisLogger.INSTANCE.i("unknown|PayLevelEnterRoomBubbleLogic", "onGiftMessageReceive", "liveExtMsg=" + msg2.liveExtMsg);
        try {
            JSONObject optJSONObject = new JSONObject(msg2.liveExtMsg).optJSONObject("float_bar");
            if (optJSONObject != null) {
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "optJSONObject(\"float_bar\")");
                String tips = optJSONObject.optString("tips");
                String iconImg = optJSONObject.optString("medal_face_small");
                String bgImg = optJSONObject.optString("bg_img");
                Intrinsics.checkNotNullExpressionValue(tips, "tips");
                isBlank = StringsKt__StringsJVMKt.isBlank(tips);
                if (!isBlank) {
                    Intrinsics.checkNotNullExpressionValue(iconImg, "iconImg");
                    isBlank2 = StringsKt__StringsJVMKt.isBlank(iconImg);
                    if (!isBlank2) {
                        Intrinsics.checkNotNullExpressionValue(bgImg, "bgImg");
                        isBlank3 = StringsKt__StringsJVMKt.isBlank(bgImg);
                        if (!isBlank3) {
                            try {
                                MutableLiveData<PayLevelEnterRoomInfo> mutableLiveData = this._enterRoomInfo;
                                long j3 = msg2.sender;
                                if (j3 == com.tencent.mobileqq.qqlive.sail.c.f272176a.G()) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                c.b(mutableLiveData, new PayLevelEnterRoomInfo(j3, tips, -1L, iconImg, bgImg, z17, 24.0f, 18.0f, 0L, 0L, 0L, Color.parseColor("#8C4600"), 1792, null));
                            } catch (Exception e16) {
                                e = e16;
                                AegisLogger.INSTANCE.e("unknown|PayLevelEnterRoomBubbleLogic", "parseJson", "error, ", e);
                            }
                        }
                    }
                }
            }
        } catch (Exception e17) {
            e = e17;
        }
    }
}
